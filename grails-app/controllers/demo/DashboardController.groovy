package demo

class DashboardController {

    AuthenticationService authenticationService
    def index() {
        def response = authenticationService.getMemberId()
        [member: response]

    }
}
