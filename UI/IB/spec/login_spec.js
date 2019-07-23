var login_page = requirePage('login_page');
var Ib = requireHelper('Ib');
var users = Ib.read_from_excel('valid_credentials', 'login');
var invalid_users = Ib.read_from_excel('invalid_credentials', 'login');
var dashboard = requirePage('dashboard_page');

describe('Login', function() {
  beforeEach(() => {
    browser.get('http://10.56.188.45/nbcdn/bank?IB_USER=9910445696');
  })

  users.forEach(function(user,index) {
    it('login with valid credentials', function() {
      login_page.login(user);
      expect(dashboard.greeting_message()).toEqual('WELCOME TO YOUR');
    })
  })

  invalid_users.forEach(function(user, index) {
    it('login with invalid credentials', function() {
      login_page.login(user);
      expect(login_page.message()).toEqual(user.message);
    })
  })
})