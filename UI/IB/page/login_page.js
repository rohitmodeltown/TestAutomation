var Ib = requireHelper('ib');

class LoginPage {

  //Elements
  txt_mPin() { return element(by.model('MpinVerifyCtrl.mPINValue')) }
  btn_submit() { return element(by.buttonText('Submit'))}
  toast() { return element(by.className('toast-message')) }
  
  // Methods
  enter_mPin(user) {
    Ib.wait_for_element_present(this.txt_mPin()).sendKeys(user.mPin);
  }

  message() {
    return this.toast().getText();
  }

  submit() {
    this.btn_submit().click();
  }

  login(user) {
    this.enter_mPin(user);
    this.submit();
  }
}

module.exports = new LoginPage();