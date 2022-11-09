# LabThree

Switched to maven for dependencies.  Configuration is here:

    <property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:XE</property>
    <property name="hibernate.connection.username">lab1</property>
    <property name="hibernate.connection.password">password</property>

Set up for your local DB.

Insert works
Select fails, can't find class `Employee`