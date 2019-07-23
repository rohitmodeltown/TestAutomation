var data_card_page = requirePage('data_card_recharge_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var data_card_data = Ib.read_from_excel('valid_data', 'data_card_recharge');

describe('Data card recharge', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  data_card_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      data_card_page.visit();
      data_card_page.populate_form(data);
      data_card_page.click_proceed_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})