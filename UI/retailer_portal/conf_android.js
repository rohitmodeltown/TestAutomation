var basePath = __dirname;
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: 'target/screenshots',
  filename: 'my-report.html'
});

exports.config = {
  framework: 'jasmine',
  allScriptsTimeout: 25000,
  getPageTimeout: 25000,
  jasmineNodeOpts: {
    defaultTimeoutInterval: 25000,
    isVerbose: true,
    showColors: true
  },

  capabilities: {
    'browserName': 'chrome',
    platformName: 'android',
    deviceName: 'GIONEE F103 Pro'
  },

  // seleniumServerJar: './selenium/selenium-server-standalone-2.53.1.jar',
  // chromeDriver: './selenium/chromedriver_2.26.exe',
  // firefoxPath: './selenium/geckodriver-v0.12.0.exe',
  seleniumAddress: 'http://0.0.0.0:4723/wd/hub',
  // seleniumAddress: 'http://localhost:4723/wd/hub',
  // specs: ['spec/landing_spec.js', 'spec/payment_spec.js', 'spec/customer_registration_spec.js', 'spec/forgot_mpin_spec.js'],
  specs: ['spec/landing_spec.js', ],

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
  },

  // Close the report after all tests finish
  afterLaunch: function(exitCode) {
    return new Promise(function(resolve){
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }

}