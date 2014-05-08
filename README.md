Eclipse is notorious for "the Eclipse way" to do things.

For example, when compiling Java classes, Eclipse insists on using its own
compiler that is a lot less strict (in particular with generics) than javac. But
Eclipse's compiler also violates the Java specifications: it does not run
annotation processors as part of the compilation process as mandated, but simply
ignores that requirement. It is possible -- on a project by project basis -- to
configure the use of *specific* annotation processors. But that still fails most
of the time because they are only run in case of full builds -- when Eclipse's
default mode is to build the code incrementally.

This project demonstrates how to add a custom builder to your project that other
developers will inherit when checking out your project. The relevant change is
in the commit labeled "Add the extra builder required by Eclipse's violating the
Java specs".
