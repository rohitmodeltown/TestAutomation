XLSX = require('xlsx');
var sha512 = require('js-sha512');
var database = requireDatabase('database');
var Base64={
  _keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
  encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}
}

class Page {

  construnctor() {
    this.baseUrl = 'http://sit.airtelmoney.in/ecom/v2/#/login?REQUEST=ECOMM_SIGNON&MID=180704&TXN_REF_NO=379897755&SU=https://facebook.com&FU=http:%2F%2Fwww.google.co.in%2F&AMT=10&DATE=08032016164915&CUR=INR&MNAME=Chetann&CUST_MOBILE=7770005686';
    this.retailerURL = 'http://10.56.110.172/RetailerPortal_BugFix_MultipleReciept_Timeout/#';
  }

  get_landing_page(data = {}) {
    var that = this;
    var paramString = '';
    var params = this.read_from_excel('url', 'url')[0];
    // merge two hash. here values in "data" will override params 
    params = Object.assign(params, data);
    params.TXN_REF_NO = parseInt(Math.random()* Math.pow(10, 16));
    database.get_salt(params.MID).then(function(salt) {
      if (salt.rows[0]) {
        params.SALT = salt.rows[0][0];
        if (params.hash_required) { params.HASH = that.generateHash(params) }
      }

      if (params.hash_required) {
        paramString = 'REQUEST='+params.REQUEST+'&'+'MID='+params.MID+'&'+'TXN_REF_NO='+params.TXN_REF_NO+'&'+
                      'SU='+params.SU+'&'+'FU='+params.FU+'&'+'AMT='+params.AMT+'&'+'DATE='+params.DATE+'&'+
                      'CUR='+params.CUR+'&'+'HASH='+params.HASH + '&' + 'service=' + params.SERVICE;
      } else {
        paramString = 'REQUEST='+params.REQUEST+'&'+'MID='+params.MID+'&'+'TXN_REF_NO='+params.TXN_REF_NO+'&'+
                    'SU='+params.SU+'&'+'FU='+params.FU+'&'+'AMT='+params.AMT+'&'+'DATE='+params.DATE+'&'+
                    'CUR='+params.CUR+'&' + 'service=' + params.SERVICE;  
      }

      if (params.END_MID){
        paramString += '&' + 'END_MID=' + params.END_MID;
      }
      // var url = 'https://sit.airtelmoney.in/oneClick/#/login' + '?' + paramString;
      var url = 'http://10.12.122.23/ecom/v2/#/login' + '?' + paramString;
      console.log('URL:', url);
      browser.get(url);
    })
  }

  generateHash(params) {
    var hash = params.MID+'#'+params.TXN_REF_NO+'#'+params.AMT+'#'+params.DATE+'#'+params.SERVICE+'#'+params.SALT;
    return this.encode_hash(hash);
  }

  encode_hash(hash) {
    return sha512(hash);
  }

  read_from_excel(sheet_name, file_name) {
    XLSX.utils.sheet_to_json;
    var workbook = XLSX.readFile('resources/' + file_name + '.xlsx');
    var worksheet = workbook.Sheets[sheet_name];
    return XLSX.utils.sheet_to_json(worksheet, {header: 'a'});
  }

  wait_for_element_present(elem) {
    var until = protractor.ExpectedConditions;
    browser.wait(until.presenceOf(elem), 15000, 'Element taking too long to display!!!!');
    return elem;
  }

  wait_for_invisibility_of(elem) {
    var until = protractor.ExpectedConditions;
    browser.wait(until.invisibilityOf(elem), 10000, 'Element taking too long to display!!!!');
    return elem;  
  }

  parse_parameters(url) {
    var txn_details = {};
    url.split('?')[1].split('&').forEach(function(val, index) {
      var a = val.split('=');
      txn_details[a[0].toLowerCase()] = a[1];
    });
    // convert amt from "11" to 11.00
    txn_details.amt = txn_details.amt;
    return txn_details;
  }

  decode_base64(otp) {
    return Base64.decode(otp);
  }

}

module.exports = new Page();