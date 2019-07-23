XLSX = require('xlsx');

class Ib {

  read_from_excel(sheet_name, file_name) {
    XLSX.utils.sheet_to_json;
    var workbook = XLSX.readFile('resources/' + file_name + '.xlsx');
    var worksheet = workbook.Sheets[sheet_name];
    return XLSX.utils.sheet_to_json(worksheet, {header: 'a'});
  }

  url() {
    var login = this.read_from_excel('login', 'global')[0];
    return "http://10.56.188.45/nbcdn/bank?IB_USER=" + login.mobile;
  }

  wait_for_element_present(elem) {
    var until = protractor.ExpectedConditions;
    browser.wait(until.presenceOf(elem), 10000, 'Element taking too long to display!!!!');
    return elem;
  }
}

module.exports = new Ib();