Masters project in JAVA : Application for a bibliography
========================================================

## Features

This application aims to create a software which manage a list of books and articles.

The input is a bibtex file, gathering all the books/articles, with several attributes (e.g. year of publication, title, number of pages...).

The bibtex file may be imported, and a pdf file can be stored in the application folder for each paper.
Each article/book is stored in an XML file named "bibliographie.xml".

The top bar is a research bar. An article can be found by typing a tag in. A tag is manually set by the user (by double clicking on the "tags" cell), and is stored in an XML file so that all tags are recovered for the next launch of the software.

Similarly to the tags, it is possible to set a collection to one article by double clicking on the "Collection" cell. The collection gathers several articles, and it is also set by the user. To delete a whole collection, it is possible to go to "Edit -> Delete collection", enter the name of the collection and then click on OK ("Enter" button doesn't work yet).

Depending on the articles selected, a list of suggestions is proposed at the bottom of the window.


## Requirements

- JAVA >= 8.0

## Documentation

A javadoc folder is located inside the main folder, and provides all classes' documentation in an html file.

## Restrictions

This software uses some free Microsoft Academic Knowledge libraries, and only allows 1000 requests per month, and 5 per second.




