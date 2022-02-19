package problemSolving;

class Account {

	private long id;
	private String mail;
	private String name;
	private boolean isAdmin;
	private String language;

	private Account(Builder builder) {
		id = builder.id;
		mail = builder.mail;
		name = builder.name;
		isAdmin = builder.isAdmin;
		language = builder.language;
	}

	public static Id builder() {
		return new Builder();
	}

	interface Id {
		Mail id(long id);
	}

	interface Mail {
		Name mail(String mail);
	}

	interface Name {
		Builder name(String name);
	}

	// Our Builder implements the new interfaces.
	private static class Builder implements Id, Mail, Name {

		private long id;
		private String mail;
		private String name;
		private boolean isAdmin = false;
		private String language = "en";

		@Override
		public Mail id(long id) {
			this.id = id;
			return this;
		}

		@Override
		public Name mail(String mail) {
			this.mail = mail;
			return this;
		}

		@Override
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder isAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public Account build() {
			return new Account(this);
		}
	}
}
