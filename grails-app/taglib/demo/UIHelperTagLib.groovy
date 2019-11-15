package demo

class  UIHelperTagLib {

    static namespace = "UIHelper"
    AuthenticationService authenticationService

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }
    def memberActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class:"nav-dark dropdown-toggle", "data-toggle":"dropdown"){authenticationService.getMemberName()}
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "changePassword", action: "index", class: "dropdown-item bg-dark"){g.message(code:"changePassword")}
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item bg-dark"){g.message(code:"logout")}
       out << "</div></li>"
    }

    def leftNavigation = { attrs, body ->
        List navigations = []

        if(authenticationService.isAdministratorMember()){
            navigations.add([controller: "member", action: "index", name: "User list"])
//            [controller: "member", action: "index", name: "User list"]
        }
        else {
            navigations.add([controller: "dashboard", action: "index", name: "dashboard"])
            navigations.add([controller: "changePassword", action: "index", name: "changePassword"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

}