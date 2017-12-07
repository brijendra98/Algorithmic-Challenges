# Contacts

We're going to make our own Contacts application! The application must perform two types of operations:

- `add name`, where *name* is a string denoting a contact name. This must store *name* as a new contact in the application.
- `find partial`, where *partial* is a string denoting a partial name to search the application for. It must count the number of contacts starting with *partial* and print the count on a new line.

Given sequential *add* and *find* operations, perform each operation in order.

## Input Format

The first line contains a single integer, *n*, denoting the number of operations to perform.
Each line *i* of the *n* subsequent lines contains an operation in one of the two forms defined above.

## Constraints

- 1 <= *n* <= 10^5
- 1 <= | *name* | <= 21
- 1 <= | *partial* | <= 21
- It is guaranteed that *name* and *partial* contain lowercase English letters only.
- The input doesn't have any duplicate *name* for the *add* operation.

## Output Format

For each `find partial` operation, print the number of contact names starting with *partial* on a new line.

## Sample Input

```
4
add hack
add hackerrank
find hac
find hak
```

## Sample Output

```
2
0
```
