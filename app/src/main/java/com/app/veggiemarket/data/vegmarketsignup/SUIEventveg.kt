package  com.app.veggiemarket.data.vegmarketsignup

sealed class SUIEventveg{

    data class FirstNameChanged(val firstName:String) : SUIEventveg()
    data class LastNameChanged(val lastName:String) : SUIEventveg()
    data class EmailChanged(val email:String): SUIEventveg()
    data class PasswordChanged(val password: String) : SUIEventveg()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : SUIEventveg()

    object RegisterButtonClicked : SUIEventveg()
}
