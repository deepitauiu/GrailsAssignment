package demo.domain

import demo.GlobalConfig

class Me {

    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType= GlobalConfig.User_Type.REGULAR_MEMBER
    String identityHash
    Date identityHashLastUpdate
    Boolean isActive = true

    Date lastCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true)
        password(blank: false,minSize: 6)
        lastName(nullable: true)
        identityHash(nullable: true)
        identityHashLastUpdate(nullable: true)
    }
    def beforeInsert(){
        this.password=this.password.encodeAsMD5()
    }

    def beforeUpdate(){
        this.password=this.password.encodeAsMD5()
    }
}
