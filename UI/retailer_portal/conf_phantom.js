var basePath = __dirname;
var path = "";
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');


var reporter = new HtmlScreenshotReporter({
  dest: 'target/screenshots',
  filename: 'my-report.html'
});

exports.config = {
	directConnect: false,

  allScriptsTimeout: 25000,
  getPageTimeout: 55000,
  jasmineNodeOpts: {
    defaultTimeoutInterval: 25000,
    isVerbose: true,
    showColors: true
  },
    // Capabilities to be passed to the webdriver instance.
	capabilities: {
	    'browserName': 'phantomjs',
	    'phantomjs.binary.path': require('phantomjs-prebuilt').path,
	    'phantomjs.ghostdriver.cli.args': ['--loglevel=DEBUG'],

      'proxy': {
        'proxyType': 'manual',
        'httpProxy': '10.56.108.156:4145',
        'httpsProxy': '10.56.108.156:4145',
        'sslProxy': '10.56.108.156:4145'
      }
	  },
	  
  seleniumServerJar: './selenium/selenium-server-standalone-2.53.1.jar',
  chromeDriver: './selenium/chromedriver-2-40',
  firefoxPath: './selenium/geckodriver-v0.12.0.exe',
	  
	framework: 'jasmine2',		  
  retailerURL: 'http://10.56.110.172/RetailerPortal_BugFix_MultipleReciept_Timeout/#',  
  specs: ['spec/moneyTransfer/retailer_customerRegister_spec.js'],
 
  // Setup the report before any tests start
  beforeLaunch: function() {
 
    return new Promise(function(resolve){
      reporter.beforeLaunch(resolve);
    });
  },

  onPrepare: function() {
    browser.driver.manage().window().maximize();
    jasmine.getEnv().addReporter(reporter);
    // jasmine.getEnv().addReporter(prettyReporter);

    global.requirePage = function(page) {
      return require(basePath + '/page/' + page + '.js')
    }

    global.requireHelper = function(helper) {
      return require(basePath + '/helpers/' + helper + '.js');
    }
    
    global.requireDatabase = function(database) {
        return require(basePath + '/' + database + '.js');
    }

    var AllureReporter = require('jasmine-allure-reporter');
    jasmine.getEnv().addReporter(new AllureReporter({
      resultsDir: 'allure-results'
    }));

    jasmine.getEnv().afterEach(function(done){
      browser.takeScreenshot().then(function (png) {
        allure.createAttachment('Screenshot', function () {
          return new Buffer(png, 'base64')
        }, 'image/png')();
        done();
      })
    });   

  },

  // Close the report after all tests finish
  afterLaunch: function(exitCode) {
    return new Promise(function(resolve){
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }

}
