package ru.optima.ildar.passportization.policy.molel;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class TopicDAB extends DatabaseAccess {
/**	
public static com.ibm.db.DatabaseConnection ConToPassport() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("ru.optima.ildar.passportization.policy.molel.TopicDAB.ConToPassport");
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
public static com.ibm.db.SQLStatementMetaData DeleteTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.TopicDAB.DeleteTopic";
  String statement = "DELETE FROM DB2ADMIN.TOPICS WHERE ( ( DB2ADMIN.TOPICS.TOPICID = :TOPICID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("TOPICID", 4, 4);
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
504b030414g08g08gfd996a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12e57771327274f1f5f4d30bf1
0ff0740e46516364600952c39a9698539c8a26630a36d3g4d94a0998c6640ac8a22625ac2c0802cc06c686084ee5ca018c8
6b2668d69981ac63324277850948981d6cb9a70b9a9c11488ea5a4a834152d98cc21c1c46185451fb305c87ab02eg504b07
0814d57621cdgggbc01gg504b010214g14g08g08gfd996a2f14d57621cdgggbc01gg0cgggggggg
ggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0701gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData InsertTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.TopicDAB.InsertTopic";
  String statement = "INSERT INTO DB2ADMIN.TOPICS ( TOPICID, CAPTION, FD ) VALUES ( :TOPICID, :CAPTION, :FD )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("TOPICID", 4, 4);
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
504b030414g08g08g59996a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606065ea042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6d6a60141fe21fe0e9ec0994e3b082329195b01a02751a94
30f0bb381939baf87afae9811505a319631cefec1810e2e9ef87c50a638415a8728c6640ac8a22625ac2c0802cc06c6a6008
e272a3081a1a18a19b051433048a1961780fee2e0e2b2813459b05481b4b4951692ab2301b482728bc98addc5cg504b0708
f2ebc23bccggg9401gg504b010214g14g08g08g59996a2ff2ebc23bccggg9401gg0cggggggggg
gggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0601gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.TopicDAB.SelectTopic";
  String statement = "SELECT DB2ADMIN.TOPICS.TOPICID, DB2ADMIN.TOPICS.CAPTION, DB2ADMIN.TOPICS.FD FROM DB2ADMIN.TOPICS WHERE ( ( DB2ADMIN.TOPICS.TOPICID = :TOPICID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.TOPICS");
    aSpec.addColumn("TOPICS.TOPICID", 4,4);
    aSpec.addColumn("TOPICS.CAPTION", 12,12);
    aSpec.addColumn("TOPICS.FD", 91,91);
    aSpec.addParameter("TOPICID", 4, 4);
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
504b030414g08g08gb2986a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060629a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f54c220e4e264e4e8e2ebe9a717e21fe0e91cace7e682
a10ca8591c5d99b3634088a7bf1f865a032c6ac194278ab9ec460616f10620d568ce3234300689f2a39981a2c6c8c012a486
352d31a738154dc6146ca6019a284133992dc141648c2cc66806c4aa2822a6406c8d62b625281841021c18c28620016e0c61
0390g1f8ae5c69896331b1a18a1070e50cc108be7cc409e63324217360109b363097ba01c389e584a8a4a53d122c51c1229
1c5658f4315b80acc7d005f49431282531591a620803d533191a610883a2c804g504b0708a46967b42301gged02gg50
4b010214g14g08g08gb2986a2fa46967b42301gged02gg0cggggggggggggggggg6275696c64
65722064617461504b0506gggg01g01g3aggg5d01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectTopicAll() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.TopicDAB.SelectTopicAll";
  String statement = "SELECT DB2ADMIN.TOPICS.TOPICID, DB2ADMIN.TOPICS.CAPTION, DB2ADMIN.TOPICS.FD FROM DB2ADMIN.TOPICS ORDER BY DB2ADMIN.TOPICS.CAPTION";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("DB2ADMIN.TOPICS");
    aSpec.addColumn("TOPICS.TOPICID", 4,4);
    aSpec.addColumn("TOPICS.CAPTION", 12,12);
    aSpec.addColumn("TOPICS.FD", 91,91);
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
504b030414g08g08ga9986a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060611a042612cead65e0a7bfe52b6
da1da68ea98481d9c4c0b08481d1b0b490a18e810922c66a6c60146f54c220e4e264e4e8e2ebe9a717e21fe0e91cace7e682
a10ca8591c5d99b3634088a7bf1f865a032c6ac19427aab98606c620b5fc686a51d49840cc6334401665b6047bc618598cd1
0c885551444c4b1818500cb304f91724c081216c0812e0c61036g09f0a1d86d8c6937b3a181117ae002c50cd1dd0df48d31
d6d0c11292cc1620fd2c2545a5a968ae3206c51993a5218630503d93a111863028f84cg504b0708975c6785f4ggg5702
gg504b010214g14g08g08ga9986a2f975c6785f4ggg5702gg0cggggggggggggggggg6275
696c6465722064617461504b0506gggg01g01g3aggg2e01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData UpdateTopic() throws java.lang.Throwable {
  String name = "ru.optima.ildar.passportization.policy.molel.TopicDAB.UpdateTopic";
  String statement = "UPDATE DB2ADMIN.TOPICS SET TOPICID = :TOPICID, CAPTION = :CAPTION, FD = :FD WHERE ( ( DB2ADMIN.TOPICS.TOPICID = :TOPIC_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("TOPICID", 4, 4);
    aSpec.addParameter("CAPTION", 12, 12);
    aSpec.addParameter("FD", 91, 91);
    aSpec.addParameter("TOPIC_ID", 4, 4);
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
504b030414g08g08gd0996a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060631a042612cead65e0a7bfe52b6
da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6c6460882ec66d666010efec1810e2e9ef57c2c061056522
2b613732b08837883740d7ca6a08b40528caefe264e4e8e2ebe9a717e21fe0e91c8c613c58d8d305643c9489628c918125c8
18d6b4c49ce25414cd206fc0dd8666b9918129d8490668a2849d043215ee24545319cd80581545c4b484810125100d0d8c30
02d6101cb0c6684e31033985c908dd8526206176ec216104926329292a4d458b0173480c704242301e5523b305c87e0c6d6c
a0c0072503662b3754f54009105710g504b070833a1ead61201gg8002gg504b010214g14g08g08gd0996a2f33a1
ead61201gg8002gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g
01g3aggg4c01gggg
**end of SQL Assist data**/
}
}
