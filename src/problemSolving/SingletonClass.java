package problemSolving;

public class SingletonClass {

	public long id; // *
	public String name; // *
	private String otherProp; // ?

	private SingletonClass(SingletonClassBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.otherProp = builder.otherProp;
	}

	private interface withId {
		withName id(long id);
	}

	private interface withName {
		SingletonClassBuilder name(String name);
	}

	static class SingletonClassBuilder implements withId, withName {

		public long id;
		public String name;
		private String otherProp;
		
		private SingletonClassBuilder() {
			// TODO Auto-generated constructor stub
		}
		
		public SingletonClassBuilder with() {
			return this;
		}

		@Override
		public withName id(long id) {
			this.id = id;
			return null;
		}

		@Override
		public SingletonClassBuilder name(String name) {
			this.name = name;
			return this;
		}

		public SingletonClassBuilder otherProp(String otherProp) {
			this.otherProp = otherProp;
			return this;
		}

		public SingletonClass build() {
			return new SingletonClass(this);
		}
	}
}
