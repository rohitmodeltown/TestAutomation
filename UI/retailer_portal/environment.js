  // Common configuration files with defaults plus overrides from environment vars
var webServerDefaultPort = 8081;

module.exports = {
// The address of a running selenium server.You can add your remote address here
seleniumAddress:
(process.env.SELENIUM_URL || 'http://localhost:4444/wd/hub'),

// Capabilities to be passed to the webdriver instance.
capabilities: {
'browserName':
    (process.env.TEST_BROWSER_NAME || 'chrome'),
'version':
    (process.env.TEST_BROWSER_VERSION || 'ANY')
},

 // Default http port to host the web server
webServerDefaultPort: webServerDefaultPort,

 // Protractor interactive tests
 interactiveTestPort: 6969,

 // A base URL for your application under test.
 baseUrl:
'http://' + (process.env.HTTP_HOST || '10.12.11.150') +
      ':' + (process.env.HTTP_PORT || webServerDefaultPort)

};