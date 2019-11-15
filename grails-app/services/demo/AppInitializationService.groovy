package demo
class AppInitializationService {
    static initialize() {
        initMember()
    }

    private static initMember() {
        if (Member.count() == 0) {
            Member member = new Member()
            member.firstName = "Admin"
            member.lastName = "Administrator"
            member.email = "admin@localhost.local"
            member.password = "admin"
            member.memberType = GlobalConfig.User_Type.ADMINISTRATOR
            member.save(flash: true)
        }
    }

}
