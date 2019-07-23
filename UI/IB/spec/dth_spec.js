var dth_page = requirePage('dth_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var dth_data = Ib.read_from_excel('valid_data', 'dth');

describe('DTH recharge', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  dth_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      dth_page.visit();
      dth_page.populate_form(data);
      dth_page.click_proceed_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})