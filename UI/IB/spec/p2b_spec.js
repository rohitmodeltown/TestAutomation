var p2b_page = requirePage('p2b_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var p2b_data = Ib.read_from_excel('valid_data', 'p2b');

describe('P2B',function() {
  beforeEach(() => {
    browser.get(Ib.url());
  })

  p2b_data.forEach(function(data, index) {
    it('successful p2b money transfer', function() {
      p2b_page.visit();
      p2b_page.populate_form(data);
      p2b_page.click_send_now_btn();
      p2b_page.click_proceed_btn();
      browser.sleep('4000');
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })

})