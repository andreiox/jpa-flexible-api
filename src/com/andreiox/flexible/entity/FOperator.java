package com.andreiox.flexible.entity;

import javax.persistence.Query;

import com.andreiox.flexible.model.IOperator;

public enum FOperator implements IOperator {

	EQUAL("=") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	NOT_EQUAL("!=") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	GREATER_THAN(">") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	LESS_THAN("<") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	GREATER_OR_EQUAL_THAN(">=") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	LESS_OR_EQUAL_THAN("<=") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	STARTS_WITH("LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("{0}%", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	DOESNT_START_WITH("NOT LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("{0}%", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	ENDS_WITH("LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("%{0}", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	DOESNT_END_WITH("NOT LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("%{0}", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	CONTAIN("LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("%{0}%", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	DONT_CONTAIN("NOT LIKE") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), String.format("%{0}%", value1));
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	IN("IN") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	NOT_IN("NOT IN") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param{0}", paramNumber), value1);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param" + paramNumber;
		}
	},

	IS_NULL("IS NULL") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator();
		}
	},

	IS_NOT_NULL("IS NOT NULL") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator();
		}
	},

	BETWEEN("BETWEEN") {
		@Override
		public void setQueryParameter(Query q, int paramNumber, Object value1, Object value2) {
			q.setParameter(String.format("param0{0}", paramNumber), value1);
			q.setParameter(String.format("param1{0}", paramNumber), value2);
		}

		@Override
		public String getJpqlSyntax(String attribute, int paramNumber) {
			return "x." + attribute + " " + this.getJpqlOperator() + " :param0" + paramNumber + " AND :param1" + paramNumber;
		}
	};

	private String jpqlOperator;

	FOperator(String jpqlOperator) {
		this.jpqlOperator = jpqlOperator;
	}

	public String getJpqlOperator() {
		return jpqlOperator;
	}

	public void setJpqlOperator(String jpqlOperator) {
		this.jpqlOperator = jpqlOperator;
	}

}
