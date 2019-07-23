var data_card_utility_page = requirePage('data_card_utility_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var data_card_utility_data = Ib.read_from_excel('valid_data', 'data_card_utility');

describe('Data card utility bill payment', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  data_card_utility_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      data_card_utility_page.visit();
      data_card_utility_page.populate_form(data);
      data_card_utility_page.click_proceed_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})