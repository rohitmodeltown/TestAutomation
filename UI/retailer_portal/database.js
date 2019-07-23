var oracledb = require('oracledb');
var flow = browser.controlFlow();

var database = function() {
  var that = this;
  this.get = function(deferred, query) {
    oracledb.getConnection({
    	user: "amcare_sit",
        password: "amcare_sit",
        connectString: "10.56.110.151:1521/testdb1"
    	},  function(err, connection) {
          if (err) {
            console.error(err.message);
            return;
          }
          connection.execute( query,
          [],
          function(err, result) {
            if (err) {
              console.error(err.message);
              that.doRelease(connection);
              return; 
            }
            that.doRelease(connection);
            deferred.fulfill(result.rows);
          });
        });
  };

  this.doRelease = function(connection) {
    connection.release(
      function(err) {  
           if (err) {console.error(err.message);}
      }
    );
  };

  this.get_otp = function(mobile) {
    var that = this;
    return flow.execute(function() {
      var deferred = protractor.promise.defer();
      var query = 'SELECT * from (select OTPCODE FROM ONETIMEPASSWORDPRODUCT WHERE msisdn=' + '91' + mobile + 'order by GENERATED_ON desc) where rownum=1';
      that.get(deferred, query);
      return deferred.promise;
    })
  }

  this.get_merchant_name = function(mid) {
    var that = this;
    return flow.execute(function() {
      var deferred = protractor.promise.defer();
      var query = 'select MERCHANTNAME from ECOM_MERCHANTS where MERCHANTID=TO_CHAR(' + mid + ')';
      that.get(deferred, query);
      return deferred.promise;
    })
  }

  this.get_salt = function(mid) {
    var that = this;
    return flow.execute(function() {
      var deferred = protractor.promise.defer();
      var query = 'select SALT from ECOM_MERCHANTS where MERCHANTID=TO_CHAR(' + mid + ')';
      that.get(deferred, query);
      return deferred.promise;
    })
  }
}

module.exports = new database();