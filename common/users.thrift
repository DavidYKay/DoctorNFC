namespace java co.gargoyle.hellothrift.users
namespace py users

struct User {
    1:string first_name,
    2:string last_name,
    3:string email
}

service UserService {
    bool add_user(1:User user),
    list<User> get_users()
}
