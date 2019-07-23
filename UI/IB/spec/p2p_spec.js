var p2p_page = requirePage('p2p_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var p2p_data = Ib.read_from_excel('valid_data', 'p2p');

describe('P2P',function() {
  beforeEach(() => {
    browser.get(Ib.url());
  })

  p2p_data.forEach(function(data, index) {
    it('successful p2p money transfer', function() {
      p2p_page.visit();
      p2p_page.populate_form(data);
      p2p_page.click_send_now_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })

})