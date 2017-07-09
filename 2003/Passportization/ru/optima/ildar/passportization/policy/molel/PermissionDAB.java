package ru.optima.ildar.passportization.policy.molel;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class PermissionDAB extends DatabaseAccess {
/**	
public static com.ibm.db.DatabaseConnection connToPassport() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("ru.optima.ildar.passportization.policy.molel.PermissionDAB.connToPassport");
    connection.setDriverName("COM.ibm.db2.jdbc.app.DB2Driver");
    connection.setDataSourceName("jdbc:db2:passport");
    connection.setUserID("");
    connection.setPromptUID(false);
    connection.setAutoCommit(true);
    connection.setPassword("");
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;
}
*/
public static com.ibm.db.SQLStatementMetaData DeleteGroupPerm() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeleteGroupPerm";
  String statement = "DELETE FROM DB2ADMIN.USERGROUPSPERMISSIONS WHERE ( ( DB2ADMIN.USERGROUPSPERMISSIONS.USERGROUPID = :USERGROUPID ) AND ( DB2ADMIN.USERGROUPSPERMISSIONS.PERMISSIONID = :PERMISSIONID ) AND ( DB2ADMIN.USERGROUPSPERMISSIONS.SUBTOPICID = :SUBTOPICID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERGROUPID", 4, 4);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g3c876e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060679a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b8b490a18e810922c66e6460116f146fg1437c41037c014673534300689cab9381939ba
f87afae98506bb06b907f987060407b806f97a06077bfafb05a3683132b08c3702d2698939c5a918328638650c70c898824c
6334c01035c42a6a8045d4186402695e3006194faa16d2020a18e6e6f186204dbc5608259e2ec86a18cd80581545c4b48481
015980d9d0c0083dda8062a0d031c18862432c516c6460060a1f2623f460330385013661036cc2262043b882439d42fc033c
9d51bd0196061ac683cb9f60054063b9e1a186216f84335119614f54e0f005a7756e2b9cce02cbb3941495626a0567071e2b
1c2e62b6g05315827g504b0708c37efd763e01ggc003gg504b010214g14g08g08g3c876e2fc37efd763e01gg
c003gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg
7801gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData DeletePermission() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeletePermission";
  String statement = "DELETE FROM DB2ADMIN.SYSTEMPERMISSIONS WHERE ( ( DB2ADMIN.SYSTEMPERMISSIONS.PERMISSIONID = :PERMISSIONID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g4b966b2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12957271327274f1f5f4d30b8e
0c0e71f50d700df2f50c0ef6f4f70b46516e64600952ce9a9698539c8a26630a36deg4d9414e319cd80581545c4b4848101
5980d9d0c008dd13403190874dd06c3603d9cc6484ee201390300fc2059e2e680a8c400a584a8a4a53d142d01c1282bc56b8
34335b801c02d60ag504b0708d4eba248d9gggdc01gg504b010214g14g08g08g4b966b2fd4eba248d9gggdc
01gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg13
01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData DeleteUserPerm() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeleteUserPerm";
  String statement = "DELETE FROM DB2ADMIN.USERPERMISSIONS WHERE ( ( DB2ADMIN.USERPERMISSIONS.USERID = :USERID ) AND ( DB2ADMIN.USERPERMISSIONS.PERMISSIONID = :PERMISSIONID ) AND ( DB2ADMIN.USERPERMISSIONS.SUBTOPICID = :SUBTOPICID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERID", 4, 4);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g04866e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060679a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b8b490a18e810922c66e6460116f146fg1437c41037c0146735343006894ab8381939ba
f87afae98506bb0605b806f97a06077bfafb05a3283632b08c3702d2698939c5a918328638650c70c898824c6334c01035c4
2a6a8045d4186402b18e3706194cbc6262830518b6e6f18620e5bc5608259e2ec86a18cd80581545c4b48481015980d9d0c0
083d7a8062a0b030c1884a432c51696460060a0d2623f4403203f91b9bb00136611390215cc1a14e21fe019ecea8deg4b03
0de3c1e54fb002a0b16ca0f0c29032c2997a8cb0a71e70d0829333b7154e1781e5594a8a4a31b582533cbb15a663982d4001
0bd604g504b0708780499fc3801gg9e03gg504b010214g14g08g08g04866e2f780499fc3801gg9e03gg0cg
gggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7201gggg

**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData InsertGroupPerm() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertGroupPerm";
  String statement = "INSERT INTO DB2ADMIN.USERGROUPSPERMISSIONS ( USERGROUPID, PERMISSIONID, FD, SUBTOPICID ) VALUES ( :USERGROUPID, :PERMISSIONID, :FD, :SUBTOPICID )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERGROUPID", 4, 4);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08gda866e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6a0814362861907371327274f1f5f4d30b0d760d720ff20f
0d080e700df2f50c0ef6f4f70b46d6c20f3209aeca13c34801903c422fa602a00146a806f0582171d1cc3242338bd70a998f
ac98d10c885551444c4b18189005984d0d0c415c0e1441430323743702c50c816246c8627c20c704873a85f807783a839cc2
6d85e0a1293446518866b605c86c9692a2d25464613690f1a01862b6727301g504b0708cff7c6c7f0ggg0602gg504b
010214g14g08g08gda866e2fcff7c6c7f0ggg0602gg0cggggggggggggggggg6275696c6465
722064617461504b0506gggg01g01g3aggg2a01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData InsertPermission() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertPermission";
  String statement = "INSERT INTO DB2ADMIN.SYSTEMPERMISSIONS ( PERMISSIONID, CAPTION, FD ) VALUES ( :PERMISSIONID, :CAPTION, :FD )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("CAPTION", 12, 12);
    aSpec.addParameter("FD", 91, 91);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08gbc956b2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606065ea042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6a0814362861907271327274f1f5f4d30b8e0c0e71f50d70
0df2f50c0ef6f4f70b46562eg320521e789611e374881b363400850165d0ea8d9084d33af15321f5931a31910aba2889896
3030200b309b1a1882b81c2882860646e81603c50c816246680e35423894c30aca44d16601d2c65252549a8a2ccc06d2090a
49662b3717g504b0708162650b8d6gggae01gg504b010214g14g08g08gbc956b2f162650b8d6gggae01gg
0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg1001gg
gg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData InsertUserPerm() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertUserPerm";
  String statement = "INSERT INTO DB2ADMIN.USERPERMISSIONS ( USERID, PERMISSIONID, FD, SUBTOPICID ) VALUES ( :USERID, :PERMISSIONID, :FD, :SUBTOPICID )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERID", 4, 4);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g52856e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6a0814362861907071327274f1f5f4d30b0d760d0a700df2
f50c0ef6f4f70b46562cg320321e789611a97a981513cc8g9014bb1584856682119a09bc56c87c64c58c6640ac8a22625a
c2c0802cc06c6a6008e272a0081a1a18a1bb0c28660814334216e303392638d429c43fc0d319e4146e2b040fcd5bc6706fa1
9acb0792423603cd5a0b90b52c2545a5a9c8c26c209b4191c16ce5e602g504b07080c711412eegggf101gg504b0102
14g14g08g08g52856e2f0c711412eegggf101gg0cggggggggggggggggg6275696c64657220
64617461504b0506gggg01g01g3aggg2801gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectGroupPermForSubTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectGroupPermForSubTopic";
  String statement = "SELECT DB2ADMIN.USERGROUPSPERMISSIONS.PERMISSIONID FROM DB2ADMIN.USERGROUPSPERMISSIONS WHERE ( ( DB2ADMIN.USERGROUPSPERMISSIONS.USERGROUPID = :USERGROUPID ) AND ( DB2ADMIN.USERGROUPSPERMISSIONS.SUBTOPICID = :SUBTOPICID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.USERGROUPSPERMISSIONS");
    aSpec.addColumn("USERGROUPSPERMISSIONS.PERMISSIONID", 4,4);
    aSpec.addParameter("USERGROUPID", 4, 4);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g44886e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060619a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1a8b490a18e810922c66a6c60146f50c2a0ede264e4e8e2ebe9a7171aec1ae41ee41f1a10
1ce01ae4eb191cece9ef17ac87607bba20eb673732b08837g99c0688862aea1813148540ebfb9285a8c0c2ce3810e644d4b
cc294ec59031c021630ad2c36880216a8045d418a496342791ea0b608098c71b8234715b05873a85f807783aa30619b32538
1a50828bd10c885551444c4b181850dc62098a2990g078a69c698a6311b1a186111c3082770e41962893c23033350483119
a107a0194831a6b00948351776ef82a541c1010f3a0c79239cd10e4e9b2c2545a5a918610c4e743c56384c65b6g79174327
3010c111ca6802g504b070845e7a5693c01gg6403gg504b010214g14g08g08g44886e2f45e7a5693c01gg6403
gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7601
gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectPermission() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectPermission";
  String statement = "SELECT DB2ADMIN.SYSTEMPERMISSIONS.PERMISSIONID, DB2ADMIN.SYSTEMPERMISSIONS.CAPTION, DB2ADMIN.SYSTEMPERMISSIONS.FD FROM DB2ADMIN.SYSTEMPERMISSIONS WHERE ( ( DB2ADMIN.SYSTEMPERMISSIONS.PERMISSIONID = :PERMISSIONID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.SYSTEMPERMISSIONS");
    aSpec.addColumn("SYSTEMPERMISSIONS.PERMISSIONID", 4,4);
    aSpec.addColumn("SYSTEMPERMISSIONS.CAPTION", 12,12);
    aSpec.addColumn("SYSTEMPERMISSIONS.FD", 91,91);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g84936b2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060629a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f54c220ebe264e4e8e2ebe9a7171c191ce2ea1be01ae4
eb191cece9ef17ace7e682a103688e121e1dce8e012140068636831206753cda106c4f142bd98d0c2ce20d40bad11c6f6860
0c1295c26d268a7223034b9072d6b4c49ce254341953b0f10668a2a418cf6c090e5e636431463320564511312d616040b1c5
12140320010e0c614390g3786b00148800fc56e634cbb990d0d8cd0430c286688c59b66206f3219a10b9b80847970c50a50
013846594a8a4a53d1a2cb1c125dbc56b834335b801c82a115e83d63507264b234c41006aa673234c21006459b09g504b07
088b6cdfd13101gg3203gg504b010214g14g08g08g84936b2f8b6cdfd13101gg3203gg0cgggggggg
ggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg6b01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectPermissionAll() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectPermissionAll";
  String statement = "SELECT DB2ADMIN.SYSTEMPERMISSIONS.PERMISSIONID, DB2ADMIN.SYSTEMPERMISSIONS.CAPTION, DB2ADMIN.SYSTEMPERMISSIONS.FD FROM DB2ADMIN.SYSTEMPERMISSIONS ORDER BY DB2ADMIN.SYSTEMPERMISSIONS.CAPTION";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.SYSTEMPERMISSIONS");
    aSpec.addColumn("SYSTEMPERMISSIONS.PERMISSIONID", 4,4);
    aSpec.addColumn("SYSTEMPERMISSIONS.CAPTION", 12,12);
    aSpec.addColumn("SYSTEMPERMISSIONS.FD", 91,91);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g6f956b2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060611a042612cead65e0a7bfe52b6
da1da68ea98481d9c4c0b08481d1b0b490a18e810922c66a6c60146f54c220ebe264e4e8e2ebe9a7171c191ce2ea1be01ae4
eb191cece9ef17ace7e682a103688e121e1dce8e012140068636831206753cda106c4f542b0d0d8c417aa570eb45516e02b1
8ad1g5994d912ec7b636431463320564511312d61604031cc12144020010e0c614390g3786b00148800fc56e634cbb990d
0d8cd06303286688ee6ea06fc09e2731bc992d4046b1941495a6a239d01814df4c968618c240f54c864618c2a0903401g50
4b07082a464a7a0101gg9302gg504b010214g14g08g08g6f956b2f2a464a7a0101gg9302gg0cgggggg
ggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg3b01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectUserPermForSubTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectUserPermForSubTopic";
  String statement = "SELECT DB2ADMIN.USERPERMISSIONS.PERMISSIONID FROM DB2ADMIN.USERPERMISSIONS WHERE ( ( DB2ADMIN.USERPERMISSIONS.USERID = :USERID ) AND ( DB2ADMIN.USERPERMISSIONS.SUBTOPICID = :SUBTOPICID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.USERPERMISSIONS");
    aSpec.addColumn("USERPERMISSIONS.PERMISSIONID", 4,4);
    aSpec.addParameter("USERID", 4, 4);
    aSpec.addParameter("SUBTOPICID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g84866e2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060619a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1a8b490a18e810922c66a6c60146f50c2a0eae264e4e8e2ebe9a7171aec1a14e01ae4eb19
1cece9ef17ac87607bba20eb643732b08837ge965344431d1d0c018242a81cb4414c5460696f14047b1a625e614a762c818
e0903105e96134c01035c0226a0c524bac63887739d0fbe6f18620e5dc56c1a14e21fe019ecea801c46c090e6e94c0613403
62551411d312060614575882620424c081629a31a669cc86064658c430c2061c558658a2cac8c00c143a4c46e8816606528c
296c0252cd85ddbb6069a02e3650a0614819e18c6570f26329292a4dc5085e70ea62b7c23490d902e4490c4dc0a0034720a3
09g504b0708c9c420ef3601gg4203gg504b010214g14g08g08g84866e2fc9c420ef3601gg4203gg0cggg
gggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7001gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData UpdatePermission() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.PermissionDAB.UpdatePermission";
  String statement = "UPDATE DB2ADMIN.SYSTEMPERMISSIONS SET PERMISSIONID = :PERMISSIONID, CAPTION = :CAPTION, FD = :FD WHERE ( ( DB2ADMIN.SYSTEMPERMISSIONS.PERMISSIONID = :PERMISSION_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("PERMISSIONID", 4, 4);
    aSpec.addParameter("CAPTION", 12, 12);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("PERMISSION_ID", 4, 4);
    // user code begin {1} 
    // user code end {1}
  }
  catch(java.lang.Throwable e){
    // user code begin {2} 
    // user code end {2}
    throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g04966b2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060631a042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6c6460882ec66d666010efec1810e2e9ef57c2c061056522
2b613732b08837883740d7ca6a08b405282ae5e264e4e8e2ebe9a7171c191ce2ea1be01ae4eb191c0c34251845b991812548
396b5a624e712ab28cgc8b9085d9e180ee70629803b12cd154606a660b719a08992e236463320564511312d616040093c43
03238cg350407a8318a6740018aea195e2b643e9a33cd40ce64324277bd094898078f3e2390029692a2d254b4b83287c415
1f92a5f1a8ba992d40cec6d0cb06723928d5305bb9a1aa074a80b882g504b07084570ac5e1f01ggaf02gg504b010214
g14g08g08g04966b2f4570ac5e1f01ggaf02gg0cggggggggggggggggg6275696c6465722064
617461504b0506gggg01g01g3aggg5901gggg
**end of SQL Assist data**/
}
}
