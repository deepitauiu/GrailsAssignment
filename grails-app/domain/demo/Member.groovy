package demo

//import demo.GlobalConfig

class Member {

    Integer id
    String firstName
    String lastName
    String address
    String phone
    String email
    Date birthDate
    String password
    String memberType= GlobalConfig.User_Type.REGULAR_MEMBER
    String identityHash
    Date identityHashLastUpdate
    Boolean isActive = true

    static constraints = {
        email(matches: "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))\$", nullable: false, unique: true)
        password(blank: false,minSize: 1)
        lastName(nullable: true)
        address(nullable: true)
        phone(matches: "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$",nullable: true)
        identityHash(nullable: true)
        identityHashLastUpdate(nullable: true)
        birthDate(nullable: true)

    }
    def beforeInsert(){
        this.password=this.password.encodeAsMD5()
    }

    def beforeUpdate(){
        this.password=this.password.encodeAsMD5()
    }
}

