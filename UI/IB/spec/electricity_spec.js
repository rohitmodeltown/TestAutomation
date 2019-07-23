var electricity_page = requirePage('electricity_page');
var Ib = requireHelper('ib');
var user = Ib.read_from_excel('user', 'electricity');
// var electricity_data = Ib.read_from_excel('valid_data', 'prepaid');
var success_transaction_page = requirePage('success_transaction_page');
var electricity_data = Ib.read_from_excel('electricity', 'electricity');

describe('Utility: Electricity bill payment', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  electricity_data.forEach(function(data, index) {
    it('pay electricity bill', function() {
      electricity_page.visit(user[0]);
      electricity_page.populate_form(data);
      electricity_page.click_pay_bill_btn();
      
      // browser.sleep(6000);
    })
  })
    
})