package control;

import java.util.List;

public class FlexibleQueryController {

	private static final String SELECT_SINTAXE = "SELECT [[ATTRIBUTES]] from [[CLASS]] x WHERE [[WHERE_CLAUSE]]";

	public static <T> List<T> doQuery(FQueryBuilder fqb) {

		String jpql = buildJpql(fqb);

		return null;
	}

	private static String buildJpql(FQueryBuilder fqb) {

		StringBuilder sb = new StringBuilder(SELECT_SINTAXE);

		return null;
	}

}
