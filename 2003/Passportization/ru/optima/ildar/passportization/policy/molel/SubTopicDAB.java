package ru.optima.ildar.passportization.policy.molel;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class SubTopicDAB extends DatabaseAccess {
	/**
	public static com.ibm.db.DatabaseConnection ConnToPassport() throws java.lang.Throwable, com.ibm.db.DataException {
	com.ibm.db.DatabaseConnection connection = null;
	try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("ru.optima.ildar.passportization.policy.molel.SubTopicDAB.ConnToPassport");
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
	public static com.ibm.db.SQLStatementMetaData DeleteSubTopic() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.SubTopicDAB.DeleteSubTopic";
		String statement =
			"DELETE FROM DB2ADMIN.SUBTOPICS WHERE ( ( DB2ADMIN.SUBTOPICS.SUBTOPICID = :SUBTOPICID ) )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("SUBTOPICID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
		/*V2.0
		**start of SQL Assist data**
		504b030414g08g08g6aa46a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
		243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
		da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12157271327274f1f5f4d30b0e
		750af10ff0740e46516664600952c69a9698539c8a26630a36d6g4d94186319cd80581545c4b48481015980d9d0c008ddd1
		403190074dd06c3403d9c86484ee1013903017cc7e4f1734692390344b4951692a5a789943c28bdb0abb56660b9023c01a01
		504b070867afgb0d0gggc801gg504b010214g14g08g08g6aa46a2f67afgb0d0gggc801gg0cggggg
		gggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0a01gggg
		**end of SQL Assist data**/
	}
	public static com.ibm.db.SQLStatementMetaData InsertSubTopic() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.SubTopicDAB.InsertSubTopic";
		String statement =
			"INSERT INTO DB2ADMIN.SUBTOPICS ( SUBTOPICID, CAPTION, FD, TOPICID ) VALUES ( :SUBTOPICID, :CAPTION, :FD, :TOPICID )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("SUBTOPICID", 4, 4);
			aSpec.addParameter("CAPTION", 12, 12);
			aSpec.addParameter("FD", 91, 91);
			aSpec.addParameter("TOPICID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
		/*V2.0
		**start of SQL Assist data**
		504b030414g08g08gcca36a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
		243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
		da1da68ea98481cdd4c038decda58481d1b0b490a18e810922cc6d6a60141fe21fe0e9ec0994e3b082329195b01a02751a94
		3008b9381939baf87afae905873a81d505a399641cefec1810e2e9ef87c51663842da8728c6640ac8a22625ac2c0802cc06c
		6a6008e272a3081a1a18a19b051433048a1961f810ee2e0e2b281359091f4809cc532017725b2178680a8d5114a2596f01b2
		9ea5a4a8341559980d643c28e899addc5cg504b0708b9d8cabde2gggdf01gg504b010214g14g08g08gcca36a2f
		b9d8cabde2gggdf01gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg
		01g01g3aggg1c01gggg
		**end of SQL Assist data**/
	}
	public static com.ibm.db.StatementMetaData SelectSubTopic() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.SubTopicDAB.SelectSubTopic";
		String statement =
			"SELECT DB2ADMIN.SUBTOPICS.SUBTOPICID, DB2ADMIN.SUBTOPICS.CAPTION, DB2ADMIN.SUBTOPICS.FD, DB2ADMIN.SUBTOPICS.TOPICID FROM DB2ADMIN.SUBTOPICS WHERE ( ( DB2ADMIN.SUBTOPICS.SUBTOPICID = :SUBTOPICID ) )";

		StatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.StatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addTable("DB2ADMIN.SUBTOPICS");
			aSpec.addColumn("SUBTOPICS.SUBTOPICID", 4, 4);
			aSpec.addColumn("SUBTOPICS.CAPTION", 12, 12);
			aSpec.addColumn("SUBTOPICS.FD", 91, 91);
			aSpec.addColumn("SUBTOPICS.TOPICID", 4, 4);
			aSpec.addParameter("SUBTOPICID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
		/*V2.0
		**start of SQL Assist data**
		504b030414g08g08g03a36a2fgggggggggggg0cggg6275696c64657220646174618d92cb4ac3401486
		4f27062f05c1db46c8d26d9839496ba3abb64109d80ba4eaa28b92452d4a295a272208ae7c1cfb323e83202e7c07e7a414cc
		cc2c5c84846fbef93997bcff809bcf617f38bcb8cb9e327f9acd267e2ae7b7b3c9297636176ff879cdg9eef01c053e29ec5
		5b7c5c7d7d7b2fe72b8f4970900b0915913fc02bb02573038ea340c261dcc266dc49ba7e7ad91af4fa493bf58b57121b3a4a
		38b0e867a629ecc1ed667f90f4ba86ce2578167df5552e651d7963c4e98ed691e001d15d33a9a4218f48736fb2e9e3583ba9
		15b15ca3ff8975a262c6e15f56a9abe7a81416d1d4096c94c49a04303c245035b020b06d604e60a754526096e4088efae014
		1396aeebd435431d8784b7ecab51c7c532d7e43c1f6b3b3b5eeeac7a62bfea34a808e3a26a2da0dfb4dc4541551f2c120656
		294ca08169afe12f504b0708e4b8a90a3c01gg6003gg504b010214g14g08g08g03a36a2fe4b8a90a3c01gg6003
		gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7601
		gggg
		**end of SQL Assist data**/
	}
	public static com.ibm.db.StatementMetaData SelectSubTopicForTopic()
		throws java.lang.Throwable {
		String name =
			"ru.optima.ildar.passportization.policy.molel.SubTopicDAB.SelectSubTopicForTopic";
		String statement =
			"SELECT DB2ADMIN.SUBTOPICS.SUBTOPICID, DB2ADMIN.SUBTOPICS.CAPTION, DB2ADMIN.SUBTOPICS.FD, DB2ADMIN.SUBTOPICS.TOPICID FROM DB2ADMIN.SUBTOPICS WHERE ( ( DB2ADMIN.SUBTOPICS.TOPICID = :TOPICID ) ) ORDER BY DB2ADMIN.SUBTOPICS.CAPTION";

		StatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.StatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addTable("DB2ADMIN.SUBTOPICS");
			aSpec.addColumn("SUBTOPICS.SUBTOPICID", 4, 4);
			aSpec.addColumn("SUBTOPICS.CAPTION", 12, 12);
			aSpec.addColumn("SUBTOPICS.FD", 91, 91);
			aSpec.addColumn("SUBTOPICS.TOPICID", 4, 4);
			aSpec.addParameter("TOPICID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
		/*V2.0
		**start of SQL Assist data**
		504b030414g08g08g81a36a2fgggggggggggg0cggg6275696c64657220646174618d92cd4ac3401080
		2789a18a20a8f52214bc780dbb93b4367a6a1b9480fd81563df45072a8452945dbad0882271fc7be8ccf208807dfc14c6ac1
		cdeca18790f0e5dbd9f97bff01773e8562bf7f799f3c25de38998cbcae9ade4d4667d8dc5abce1e78d0df0fcgg47a9b86f
		f0161fd75fdfa5978b95672b700221155872fe08af60ff31e4ccf5050e7c0587511d6b51336e79ddab7aafdd891b5d2f7bc5
		11d351c181413fe7a634076ed43abdb8dd62ba505032e8ab2f3d95028aea40d0995c4552f844f778244d431192e6de26e3d9
		50fb132c53b144ce2f1be93a973961d6f9e03fb32ae973ac050b691604b635b1acg98870476189604761916048a5a4a3e4f
		c99102d9d2c8cc13b90e6555af3b5b1415d26dccf72e205c30ed192e67b0a1a6f3616eea27cba96f9e1ace3955ca969d4a7b
		e0d396ebe566342dd80e25c369145b22c3b4gc12f504b070835a1ff784901ggb303gg504b010214g14g08g08g81
		a36a2f35a1ff784901ggb303gg0cggggggggggggggggg6275696c6465722064617461504b0506g
		ggg01g01g3aggg8301gggg
		**end of SQL Assist data**/
	}
	public static com.ibm.db.SQLStatementMetaData UpdateSubTopic() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.SubTopicDAB.UpdateSubTopic";
		String statement =
			"UPDATE DB2ADMIN.SUBTOPICS SET SUBTOPICID = :SUBTOPICID, CAPTION = :CAPTION, FD = :FD, TOPICID = :TOPICID WHERE ( ( DB2ADMIN.SUBTOPICS.SUBTOPICID = :SUBTOPIC_ID ) )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("SUBTOPICID", 4, 4);
			aSpec.addParameter("CAPTION", 12, 12);
			aSpec.addParameter("FD", 91, 91);
			aSpec.addParameter("TOPICID", 4, 4);
			aSpec.addParameter("SUBTOPIC_ID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
		/*V2.0
		**start of SQL Assist data**
		504b030414g08g08g22a46a2fgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
		243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060609a042612cead65e0a7bfe52b6
		da1da68ea98481cfccc0203e38d429c43fc0d3d9d3a58481db0ac12b2d64a863608228643335308e77032a60344416663632
		304417e30699e9ec1810e2e9ef57c2c0610565222b613732b08837883740d7ca6a08b405282ae4e264e4e8e2ebe9a707734d
		30860d7027735861712fab918125c824d6b4c49ce25414cd209fc09d8766bf918129d8550668a244b90a6430dc55a806339a
		01b12a8a88690903034a501a1a186104af2138788dd15c6306720d9311ba234d40c25cd8e38f0fe438e488c6f0b81148374b
		4951692a5a4c9943628a079e32e2518d66b6g391243271b2892402986d9ca0d553d5002c41501g504b07085c37885c2a01
		ggd402gg504b010214g14g08g08g22a46a2f5c37885c2a01ggd402gg0cggggggggggggggg
		gg6275696c6465722064617461504b0506gggg01g01g3aggg6401gggg
		**end of SQL Assist data**/
	}
}
