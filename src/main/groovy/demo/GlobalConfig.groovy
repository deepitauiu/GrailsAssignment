package demo

class GlobalConfig {
    public static final def User_Type = [
            ADMINISTRATOR:"ADMINISTRATOR",
            REGULAR_MEMBER:"REGULAR_MEMBER",
    ]
    public static Integer itemsPerPage(){
        return 5
    }
}
