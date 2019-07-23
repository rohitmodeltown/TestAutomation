var basePath = __dirname;
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: 'target/screenshots',
  filename: 'my-report.html'
});

exports.config = {
	directConnect: true,
    // Capabilities to be passed to the webdriver instance.
	capabilities: {
	    'browserName': 'chrome'
	  },
	  /*seleniumServerJar: './selenium/selenium-server-standalone-2.53.1.jar',
	  chromeDriver: './selenium/chromedriver_2.26.exe',
	  firefoxPath: './selenium/geckodriver-v0.12.0.exe',*/
	  
	framework: 'jasmine',		  
	baseUrl: 'http://sit.airtelmoney.in/ecom/v2/#/login?REQUEST=ECOMM_SIGNON&MID=180704&TXN_REF_NO=379897755&SU=https://facebook.com&FU=http:%2F%2Fwww.google.co.in%2F&AMT=10&DATE=08032016164915&CUR=INR&MNAME=Chetann&CUST_MOBILE=7770005686',
  retailerURL: 'http://10.56.110.172/RetailerPortal_BugFix_MultipleReciept_Timeout/#',  
  specs: ['spec/retailerPortal/retailer_signUp_spec.js'],
 //  specs: ['spec/customer_registration_spec.js'],
  // specs: ['spec/login_spec.js'],
//	specs: ['spec/transaction_spec.js'],
  //specs: ['spec/landing_spec.js', 'spec/payment_spec.js', 'spec/customer_registration_spec.js', 'spec/forgot_mpin_spec.js'],

    
  // Setup the report before any tests start
  beforeLaunch: function() {
    return new Promise(function(resolve){
      reporter.beforeLaunch(resolve);
    });
  },

  onPrepare: function() {
    browser.driver.manage().window().maximize();
    jasmine.getEnv().addReporter(reporter);

    global.requirePage = function(page) {
      return require(basePath + '/page/' + page + '.js')
    }

    global.requireHelper = function(helper) {
      return require(basePath + '/helpers/' + helper + '.js');
    }
    
    global.requireDatabase = function(database) {
        return require(basePath + '/' + database + '.js');
    }
    
    
   /* //Code to enable network throtlling
    browser.driver.setNetworkConditions({
        offline: false,
        latency: 5, // Additional latency (ms).
        download_throughput: 500 * 1024, // Maximal aggregated download throughput.
        upload_throughput: 500 * 1024 // Maximal aggregated upload throughput.
    });*/
    
  },

  // Close the report after all tests finish
  afterLaunch: function(exitCode) {
    return new Promise(function(resolve){
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }

}