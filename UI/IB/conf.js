var basePath = __dirname;
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: 'target/screenshots',
  filename: 'my-report.html'
});

exports.config = {
  framework: 'jasmine',
  jasmineNodeOpts: {
    // To specify max time protractor should wait for any async task to finish.
    allScriptsTimeout: 10000,
    isVerbose: true,
    showColors: true
  },

  capabilities: {
    browserName: 'chrome',
    'chromeOptions': {'args': ['--disable-extensions']}
  },
  seleniumServerJar: './selenium/selenium-server-standalone-2.53.1.jar',
  chromeDriver: './selenium/chromedriver_2.26.exe',

  specs: ['spec/*.js'],

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
  },

  // Close the report after all tests finish
  afterLaunch: function(exitCode) {
    return new Promise(function(resolve){
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }

}