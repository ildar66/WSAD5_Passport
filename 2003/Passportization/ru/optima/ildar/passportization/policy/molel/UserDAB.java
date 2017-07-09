package ru.optima.ildar.passportization.policy.molel;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class UserDAB extends DatabaseAccess {
	/**
public static com.ibm.db.DatabaseConnection connToPassport() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("ru.optima.ildar.passportization.policy.molel.UserDAB.connToPassport");
    connection.setDriverName("COM.ibm.db2.jdbc.app.DB2Driver");
    connection.setDataSourceName("jdbc:db2:passport");
    connection.setUserID("db2admin");
    connection.setPromptUID(false);
    connection.setAutoCommit(true);
    connection.setPassword("123456");
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;
}
*/
public static com.ibm.db.SQLStatementMetaData UserDelete() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserDelete";
  String statement = "DELETE FROM DB2ADMIN.USERS WHERE ( ( DB2ADMIN.USERS.USERID = :USERID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERID", 4, 4);
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
504b030414g08g08g4f8d692fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12e57371327274f1f5f4d30b0d
760d0a46516264600952c29a9698539c8a26630a36d2g4d9490918c6640ac8a22625ac2c0802cc06c686084ee58a018c863
2668b699816c63324277840948980d64b7a70b9a9411488aa5a4a834152d8ccc2161c46e85a98dd90264395813g504b0708
45e19458ccgggb801gg504b010214g14g08g08g4f8d692f45e19458ccgggb801gg0cggggggggg
gggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0601gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData UserInsert() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserInsert";
  String statement = "INSERT INTO DB2ADMIN.USERS ( USERID, LASTNAME, FD, MIDDLENAME, FIRSTNAME, USERPASSWORD, USERLOGIN, USERGROUPID ) VALUES ( :USERID, :LASTNAME, :FD, :MIDDLENAME, :FIRSTNAME, :USERPASSWORD, :USERLOGIN, :USERGROUPID )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERID", 4, 4);
    aSpec.addParameter("LASTNAME", 12, 12);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("MIDDLENAME", 12, 12);
    aSpec.addParameter("FIRSTNAME", 12, 12);
    aSpec.addParameter("USERPASSWORD", 12, 12);
    aSpec.addParameter("USERLOGIN", 12, 12);
    aSpec.addParameter("USERGROUPID", 4, 4);
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
504b030414g08g08gc38c692fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060671a042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc636a6014efe3181ce2e7e8eb5ac2c0690563232b623504ea
352861e07371327274f1f5f4d30b0d760d0a4656c20b321e24eae3efeee9876e8bg4c36c0313838dc3f08c3197c2067f87a
bab8f8b8421cc26d85e0212be48799e41ee41f1ae0896190gc820549b78ad90f9688619a11ac66385c44556ca05530a52c5
6e0561a105a4315240a2ba8ad10c885551444c4b18189005984d0d0c415c6eb460314609165463990d0d8cb0881902c58cd0
22c728decd3308e6382e2b3807cd8fc6703fa29a0a8e5e241330648d90239fcb0ace41719a05c8692c2545a5a9c8c26c60d7
01ad64b6727301g504b0708cd4489a83c01ggfe02gg504b010214g14g08g08gc38c692fcd4489a83c01ggfe02
gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7601
gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData UserSelect() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserSelect";
  String statement = "SELECT DB2ADMIN.USERS.USERID, DB2ADMIN.USERS.LASTNAME, DB2ADMIN.USERS.FD, DB2ADMIN.USERS.MIDDLENAME, DB2ADMIN.USERS.FIRSTNAME, DB2ADMIN.USERS.USERPASSWORD, DB2ADMIN.USERS.USERLOGIN, DB2ADMIN.USERS.USERGROUPID FROM DB2ADMIN.USERS WHERE ( ( DB2ADMIN.USERS.USERID = :USERID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.USERS");
    aSpec.addColumn("USERS.USERID", 4,4);
    aSpec.addColumn("USERS.LASTNAME", 12,12);
    aSpec.addColumn("USERS.FD", 91,91);
    aSpec.addColumn("USERS.MIDDLENAME", 12,12);
    aSpec.addColumn("USERS.FIRSTNAME", 12,12);
    aSpec.addColumn("USERS.USERPASSWORD", 12,12);
    aSpec.addColumn("USERS.USERLOGIN", 12,12);
    aSpec.addColumn("USERS.USERGROUPID", 4,4);
    aSpec.addParameter("USERID", 4, 4);
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
504b030414g08g08gfc8b692fgggggggggggg0cggg6275696c64657220646174618593cf4b024114c7
9fbb99452048856578ecd0456666d71f5b27634d16d61fb899070fe2c1a410291b23083af5e7e43fd3df104487fe87e62981
3b6fa2cb1e3ef39937f3de7cf7ed1b92f319ecf5fbe1edf07158980ca7e342246737d3f199686c2f5ec547cf0278ba038013
25ee1abcc5fbd5e757feb9feeb59126cc1b884049fdfc30b582b967498189425e4fc7351f51b41b3d08d6a9d68f9ad775add
76e013bd24e1c0a087ad7ad0247251c291416e57a3a8d7ead0e22e2d7e1174a2cb66b55123b223e150931b81ef8735a32d24
64f4d2f4026a4459cd0aab7f9ccf24ec1b9a8bcf2c255865c0d0d546cf9983341daf105304f350495e0f270f236da5b82cc9
34fa6f490f1f1cc1d63ab6bd65362a442d21d821b888204db08b20b38e132a2d8963223a08f662a24a0a104f20c812cc11e4
086608f2b1be1cda97cd99d01f43316e986609a769091dbb8837e953aba5652836e46c3ed26ee7e06f96700955f3b1b820b8
48b0ca517995a3d4a9e168dce4924d7605fb32dfc7319fac6663799c606eb63183ee0f504b0708170d2c158901ggb104g
g504b010214g14g08g08gfc8b692f170d2c158901ggb104gg0cggggggggggggggggg627569
6c6465722064617461504b0506gggg01g01g3agggc301gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData UserSelectForGroup() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserSelectForGroup";
  String statement = "SELECT DB2ADMIN.USERS.USERID, DB2ADMIN.USERS.LASTNAME, DB2ADMIN.USERS.FD, DB2ADMIN.USERS.MIDDLENAME, DB2ADMIN.USERS.FIRSTNAME, DB2ADMIN.USERS.USERPASSWORD, DB2ADMIN.USERS.USERLOGIN, DB2ADMIN.USERS.USERGROUPID FROM DB2ADMIN.USERS WHERE ( ( DB2ADMIN.USERS.USERGROUPID = :USERGROUPID ) ) ORDER BY DB2ADMIN.USERS.LASTNAME";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.USERS");
    aSpec.addColumn("USERS.USERID", 4,4);
    aSpec.addColumn("USERS.LASTNAME", 12,12);
    aSpec.addColumn("USERS.FD", 91,91);
    aSpec.addColumn("USERS.MIDDLENAME", 12,12);
    aSpec.addColumn("USERS.FIRSTNAME", 12,12);
    aSpec.addColumn("USERS.USERPASSWORD", 12,12);
    aSpec.addColumn("USERS.USERLOGIN", 12,12);
    aSpec.addColumn("USERS.USERGROUPID", 4,4);
    aSpec.addParameter("USERGROUPID", 4, 4);
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
504b030414g08g08g718c692fgggggggggggg0cggg6275696c64657220646174618d93cf4ac3401087
27a945a4522856aa9582176f527637e99fe8a9925a02492b89b5871e4a0fb528a568dd8a2078f271eccbf80c8278f01dcca4
0a26b3452f397cf9766767f6b72f9f909ecf20dfefbbd7c3fb6179329c8ecb819c5d4dc7c7c2db583c8bb79e0ef07003g87
a1b8a5f016af17ef1fa5c7d68fa74b48998c4bd0f8fc169e40ff6682b2b4c1c4a026a1689f8886ed39ed723768fa41f46df9
9dee996313bd2a6147a1bb9d96d3267245c29e423e6b0441afe3d3cd4dbaf9a9e307e7ed86d724b2216137217b8e6dbb4da5
2d24e4925bd30384232a242cb7b1a23e93b0ad682e3eb375c1ea03866e62f49c1948b3f11d628a60162ae9cbe1e46e14fb63
2ecb6b2ce15794f4cf4216c6g412696182b4a4c9da8550459822b0872049b08f2bfb11666483b20a281a01013c3fcgf104
8222c11c41896086603fd69741fb4a7126c88be191c712938fa6f9af900856455717c90b31116756bd32b1bcdc35399b8f12
ed18f85a3593d070a03a170457080ee3585bc671f368557d5c699295a93a4e437d28435d3e9ca86e7182b9dac6e49a5f504b
07089e6431449601gg1105gg504b010214g14g08g08g718c692f9e6431449601gg1105gg0cggggggg
gggggggggg6275696c6465722064617461504b0506gggg01g01g3agggd001gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData UserUpdate() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserUpdate";
  String statement = "UPDATE DB2ADMIN.USERS SET USERID = :USERID, LASTNAME = :LASTNAME, FD = :FD, MIDDLENAME = :MIDDLENAME, FIRSTNAME = :FIRSTNAME, USERPASSWORD = :USERPASSWORD, USERLOGIN = :USERLOGIN, USERGROUPID = :USERGROUPID WHERE ( ( DB2ADMIN.USERS.USERID = :USER_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("USERID", 4, 4);
    aSpec.addParameter("LASTNAME", 12, 12);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("MIDDLENAME", 12, 12);
    aSpec.addParameter("FIRSTNAME", 12, 12);
    aSpec.addParameter("USERPASSWORD", 12, 12);
    aSpec.addParameter("USERLOGIN", 12, 12);
    aSpec.addParameter("USERGROUPID", 4, 4);
    aSpec.addParameter("USER_ID", 4, 4);
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
504b030414g08g08g268d692fgggggggggggg0cggg6275696c646572206461746185534d4fc240105d
8a80200846af265ebc92ed2288eba9a6409ab4405a910387a607241a42148b3131f1e4cf913fe36f30311efc0feed02cec07
8987263b336f66e7bd7dfdf84599c51c1d8d46ee7df41c55a7d16c520de2f9dd6c7249bcfcf29d7c0d0d845e1e1042270c78
b805b7fcbcf9fe397eed709c11a36c1dd7c2b61da394b978446fc848d28506c6e12068f90e2be56872120169824db5294770
33c42156f31993ddc1b2fbf615b16ccfe956615e20424ab00664dd5ec7e9aa032abcdab78260d8f3b5752b7cdd0da044c558
0497f9b48edf1bf41d6d58990f5bd78b540845e83e403dc7b6dd56d7f25a31daa39b48e207c0b6e307d709ae40d781a414c1
17a054e6369a3e8d954a7da52c56b2ff295b04b6aec52f96a9a61aec3b9532f518218922f48b14e5096913932d39f0464d13
4078e0025d0792eff8dbe8cfc2b83680ab41b0e61c4159ade90c9ab2ba838bb0d146983ce567a59f40ff4e3c5f8c15af9f27
5edf5d310995dfa30912685dd9950d18b5346dcb785680f0e00f504b0708d137527f8001gge703gg504b010214g14g
08g08g268d692fd137527f8001gge703gg0cggggggggggggggggg6275696c6465722064617461
504b0506gggg01g01g3agggba01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData UserEnable() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.UserDAB.UserEnable";
  String statement = "UPDATE DB2ADMIN.USERS SET ENABLE = :ENABLE WHERE ( ( DB2ADMIN.USERS.USERID = :USERID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("ENABLE", 4, 4);
    aSpec.addParameter("USERID", 4, 4);
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
504b030414g08g08g3c7b742fgggggggggggg0cggg6275696c64657220646174618553cb4ec24014bd
140bd1f032ba7563e2964c0741c45549a169d2026945162c9a2e906808112cc6c4c4959f233fe337981817fe837369463a33
242e9ab4e7dc73eeb3ef3fa0af96703c1ebbf7d153549d45f36935889777f3e915f5f6d76ff473a4013c3fgc0290b3cda11
b7feb8f9fa3e79b1799c1643ae4e6a61d78a2143560b78052d810f1a8484c3a0e33b8c823493a5c460d1461acb53d20c4948
645c379839434b569b9a96e7f4aa6819a4438a981f51b76f3b3db98c0a670766108cfabe526785d7b90d10aa2d7303dbef0f
078ea22f73fd1f2fc84b487b8e65b99d9ee97524b6886cd7f183eb1da44ec925f6aedf46b3c789c4d437b32212fadfac0ad8
8c6bf274a23ed360cf9980d4e56e509fee4674c81a84ca1b64186ebba6b49d5a192887c3ecdb2ef3cfb7923721806f445d06
1b410347a051a29c486acc8ae81c45b9c45349c56b11fb2a6099db51ca9ba3e8b8172f5713e9cc2f9233cfb7d46cd9268e4a
11e53647a2fc450cc5cfc35f504b0708cfc7e1ec7201ggd703gg504b010214g14g08g08g3c7b742fcfc7e1ec7201
ggd703gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3ag
ggac01gggg
**end of SQL Assist data**/
}

}
