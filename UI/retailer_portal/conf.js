var basePath = __dirname;
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');
 
var reporter = new HtmlScreenshotReporter({
  dest: 'target/screenshots',
  filename: 'my-report.html'
});
 
exports.config = {
       directConnect: true,
       jasmineNodeOpts: {
           // To specify max time protractor should wait for any async task to finish.
           allScriptsTimeout: 20000,
           isVerbose: true,
           showColors: true
         },
       capabilities: {
           'browserName': 'chrome'
         },
         
    framework: 'jasmine2',              
    baseUrl: 'http://10.56.110.150/RetailerPortal/#/app', 
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