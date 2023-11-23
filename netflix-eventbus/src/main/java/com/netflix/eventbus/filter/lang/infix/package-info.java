/**
 * An infix notation based language for event filters. At a higher level, one creates an expression made out of multiple
 * "predicate"s chained together using the AND and OR operators.
 * <h3>Predicate</h3> A predicate by definition is an expression that results in a boolean value. There are multiple
 * predicates available in the language which are described below. On top of these predicates one can also use
 * comparison functions, described below, which results in a boolean value.
 * <h4>Between Predicate: </h4> A between predicate checks whether a value is between a lower and upper bound.
 *
 * <i>Example: "xpath("//a/b/c") between (100,150)". Here xpath() is a function which is described below.</i>
 * <b>This is only supported for numeric inputs.</b>
 * <h4>In Predicate: </h4> An in predicate checks whether a value is in a list of values provided to the function.
 * <b>This is supported for alphanumeric inputs.</b>
 *
 * <i>Example: "xpath("//a/b/c") in ("x", "y", "z")". Here xpath() is a function which is described below.</i>
 * <h4>Null Predicate: </h4> A null predicate checks whether the passed value is null.
 *
 * <i>Example: "xpath("//a/b/c") is null". Here xpath() is a function which is described below.</i>
 * <h4>Regex Predicate: </h4> A null predicate checks whether the passed value matches a provided regex.
 *
 * <i>Example: "xpath("//a/b/c") =~ "&lt;a regex&gt;"". Here xpath() is a function which is described below.</i>
 * <h4>Exists Predicate: </h4> A null predicate checks whether the passed value matches a provided regex.
 *
 * <i>Example: "xpath("//a/b/c") =~ "&lt;a regex&gt;"". Here xpath() is a function which is described below.</i>
 *
 * <h4>Comparison Functions</h4> This language currently supports the following comparison functions:
 * <ul>
 * <li>Equals: <i>Example: "xpath("//a/b/c") = "xyz". Here xpath() is a function which is described below.</i></li>
 * <li>Not Equals: <i>Example: "xpath("//a/b/c") != "xyz". Here xpath() is a function which is described below.</i></li>
 * <li>Greater than: <i>Example: "xpath("//a/b/c") &gt; "xyz". Here xpath() is a function which is described below.</i></li>
 * <li>Greater than or equals: <i>Example: "xpath("//a/b/c") &gt;= "xyz". Here xpath() is a function which is described below.</i></li>
 * <li>Lesser than: <i>Example: "xpath("//a/b/c") &lt; "xyz". Here xpath() is a function which is described below.</i></li>
 * <li>Lesser than or equals: <i>Example: "xpath("//a/b/c") &lt;= "xyz". Here xpath() is a function which is described below.</i></li>
 * </ul>
 * <b>All the above comparison functions are available only for numeric inputs.</b>
 *
 * <h4>XPath function</h4> This primarily is the only function that fetches runtime values in the filters. The XPath
 * will be run on the event object for which the filter is applied. For details about the evaluation and support
 * <a href="http://commons.apache.org/jxpath/">see this</a>
 *
 * <h5>Other value functions</h5> We also have certain functions that helps convert values in specific formats. These
 * functions are listed below:
 *
 Time millis: Converts milliseconds since epoch to a date-time string. The format of date-time pattern is as
 specified <a href="http://joda-time.sourceforge.net/apidocs/org/joda/time/format/DateTimeFormat.html">here</a>

 <i>Example: "xpath("//a/b/c") = time-millis("yyyy-MM-dd'T'HH:mm:ss:SSS", "2012-08-22T10:14:44:856") . Here xpath() is a function which is described above.</i>
 Time string: Converts a stringified time from one format to another. The format of date-time pattern is as
 specified <a href="http://joda-time.sourceforge.net/apidocs/org/joda/time/format/DateTimeFormat.html">here</a>

 <i>Example: "xpath("//a/b/c") = time-string("yyyy-MM-dd'T'hh:mm:ss:SSS","yyyy-MM-dd'T'HH:mm:ss:SSS", "2012-08-22T10:14:44:856") .

 Here xpath() is a function which is described above.</i>

 First format argument is the target format.

 Seconds format argument is the input source format.
 */
package com.netflix.eventbus.filter.lang.infix;
