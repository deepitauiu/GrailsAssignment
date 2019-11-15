package demo

class AuthenticationController {

    AuthenticationService authenticationService
    MemberService memberService

    def login() {
        if (authenticationService.isAuthenticated()) {
            redirect(controller: "dashboard", action: "index")
        }
    }


    def doLogin() {
        if (authenticationService.doLogin(params.email, params.password)) {
            if(authenticationService.isAdministratorMember()) {
                redirect(controller: "member", action: "index")
            }
            else {
                redirect(controller: "dashboard", action: "index")
            }
        } else {
            flash.message=AppUtil.infoMessage(g.message(code: "invalidEmail"),false);
            redirect(controller: "authentication", action: "login")
        }
    }


    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    def registration() {
        [member: flash.redirectParams]
    }


    def doRegistration() {
        def response = memberService.save(params)
        if (response.isSuccess) {
            authenticationService.setMemberAuthorization(response.model)
            redirect(controller: "dashboard", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }

}