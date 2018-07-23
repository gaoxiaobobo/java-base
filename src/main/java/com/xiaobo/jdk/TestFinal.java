package com.xiaobo.jdk;

public class TestFinal
{
    //只有定义成 final User user 才不会报错为什么？
    public void test(final User user)
    {
        (new Thread()
        {
            public void run()
            {
//                user = new User("other",003);
                System.out.println("user.name-->"+user.name);
            }
        }
        ).start();
    }
    public static void main(String[] args)
    {
        User user=new User();
        user.setId(007);
        user.setName("zhaoyang");

        TestFinal testFinal=new TestFinal();
        testFinal.test(user);
    }
}


class  User
{
    String name=null;
    int id;

    public User() {
    }
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
