import java.util.regex.Pattern;

/**
 * Created by OlavH on 27-Sep-16.
 */
public class Regex {


    /**
     *
     */
    public static boolean passwordCheck(String password){

        System.out.println(password);

        Pattern.compile("[A-Z]+\\d+");




        return false;
    }

    public static void main(String[] args) {

        // carplate: AA-00000,

        Pattern pattern = Pattern.compile("\\w{2}\\s\\d{5}"); // 2 word chars, 1 whitespace, then 5 digits

        String plate = "AB 82956";
        String notPlate = "ukdsa 1121";

        System.out.println(pattern.toString());
        System.out.println(plate.matches(pattern.toString()));
        System.out.println(notPlate.matches(pattern.toString()));





    }

}
/*
Character classes
[abc]	a, b, or c (simple class)
[^abc]	Any character except a, b, or c (negation)
[a-zA-Z]	a through z or A through Z, inclusive (range)
[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]]	d, e, or f (intersection)
[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)


Predefined character classes
.	Any character (may or may not match line terminators)
\d	A digit: [0-9]
\D	A non-digit: [^0-9]
\s	A whitespace character: [ \t\n\x0B\f\r]
\S	A non-whitespace character: [^\s]
\w	A word character: [a-zA-Z_0-9]
\W	A non-word character: [^\w]

Boundary matchers
^	The beginning of a line
$	The end of a line
\b	A word boundary
\B	A non-word boundary
\A	The beginning of the input
\G	The end of the previous match
\Z	The end of the input but for the final terminator, if any
\z	The end of the input

Greedy quantifiers
X?	X, once or not at all
X*	X, zero or more times
X+	X, one or more times
X{n}	X, exactly n times
X{n,}	X, at least n times
X{n,m}	X, at least n but not more than m times

Reluctant quantifiers
X??	X, once or not at all
X*?	X, zero or more times
X+?	X, one or more times
X{n}?	X, exactly n times
X{n,}?	X, at least n times
X{n,m}?	X, at least n but not more than m times

Possessive quantifiers
X?+	X, once or not at all
X*+	X, zero or more times
X++	X, one or more times
X{n}+	X, exactly n times
X{n,}+	X, at least n times
X{n,m}+	X, at least n but not more than m times

Logical operators
XY	X followed by Y
X|Y	Either X or Y
(X)	X, as a capturing group

*/
