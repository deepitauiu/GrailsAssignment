package demo

class ChangePasswordController {

    MemberService memberService
    AuthenticationService authenticationService
    def index() { }

    def update() {
        def response = authenticationService.getMemberId();
        if (!response){
            redirect(controller: "changePassword", action: "index")
        }else{
            def prevpassword = "${response.password}"
            def oldpassword = "${params.oldPassword}".encodeAsMD5()
            def newpass= "${params.newPassword}"
            def conpass= "${params.password}"
            if(oldpassword==prevpassword && newpass==conpass){
                response = memberService.update(response, params)

                if (!response.isSuccess){
                    flash.redirectParams = response.model

                    flash.message=AppUtil.infoMessage("Passwords not matched.",false)
                    redirect(controller: "changePassword", action: "index")
                }else{

                    flash.message=AppUtil.infoMessage("Password changed successfully.")
                    redirect(controller: "dashboard", action: "index")
                }
            }
            else {

                flash.message=AppUtil.infoMessage("Passwords are not match.",false)
                redirect(controller: "changePassword", action: "index")
            }


        }
    }
}
