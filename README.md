# LabThree

Switched to maven for dependencies.  Configuration is here:

    <property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:XE</property>
    <property name="hibernate.connection.username">lab1</property>
    <property name="hibernate.connection.password">password</property>

Set up for your local DB.

It is creating the schema now but failing here:

    Nov. 08, 2022 7:03:57 P.M. org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
    INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
    Exception in thread "main" java.lang.IllegalStateException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: Model.FullAddress
    at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:161)
    at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:175)
    at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:182)
    at org.hibernate.internal.SessionImpl.doFlush(SessionImpl.java:1426)
    at org.hibernate.internal.SessionImpl.managedFlush(SessionImpl.java:476)
    at org.hibernate.internal.SessionImpl.flushBeforeTransactionCompletion(SessionImpl.java:2233)
    at org.hibernate.internal.SessionImpl.beforeTransactionCompletion(SessionImpl.java:1929)
    at org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl.beforeTransactionCompletion(JdbcCoordinatorImpl.java:439)
    at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl.beforeCompletionCallback(JdbcResourceLocalTransactionCoordinatorImpl.java:183)
    at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl$TransactionDriverControlImpl.commit(JdbcResourceLocalTransactionCoordinatorImpl.java:281)
    at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:101)
    at ManageEmployee.addEmployee(ManageEmployee.java:64)
    at ManageEmployee.main(ManageEmployee.java:29)
    Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: Model.FullAddress
    at org.hibernate.engine.internal.ForeignKeys.getEntityIdentifierIfNotUnsaved(ForeignKeys.java:344)
    at org.hibernate.type.EntityType.getIdentifier(EntityType.java:432)
    at org.hibernate.type.ManyToOneType.isDirty(ManyToOneType.java:233)
    at org.hibernate.type.ManyToOneType.isDirty(ManyToOneType.java:244)
    at org.hibernate.persister.entity.DirtyHelper.isDirty(DirtyHelper.java:69)
    at org.hibernate.persister.entity.DirtyHelper.findDirty(DirtyHelper.java:44)
    at org.hibernate.persister.entity.AbstractEntityPersister.findDirty(AbstractEntityPersister.java:4522)
    at org.hibernate.event.internal.DefaultFlushEntityEventListener.dirtyCheck(DefaultFlushEntityEventListener.java:553)
    at org.hibernate.event.internal.DefaultFlushEntityEventListener.isUpdateNecessary(DefaultFlushEntityEventListener.java:209)
    at org.hibernate.event.internal.DefaultFlushEntityEventListener.onFlushEntity(DefaultFlushEntityEventListener.java:133)
    at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
    at org.hibernate.event.internal.AbstractFlushingEventListener.flushEntities(AbstractFlushingEventListener.java:214)
    at org.hibernate.event.internal.AbstractFlushingEventListener.flushEverythingToExecutions(AbstractFlushingEventListener.java:90)
    at org.hibernate.event.internal.DefaultFlushEventListener.onFlush(DefaultFlushEventListener.java:38)
    at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
    at org.hibernate.internal.SessionImpl.doFlush(SessionImpl.java:1422)
    ... 9 more
