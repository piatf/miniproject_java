Masters project in JAVA : Application for a bibliography
========================================================

## Features
This application aims to create a software which manage a list of books and articles.
The input is a bibtex file, gathering all the books/articles, with several attributes (e.g. year of publication, title, number of pages...).
The bibtex file may be imported, and a pdf file can be stored in the application folder for each paper.
Each article/book is stored in an XML file named "bibliographie.xml".
The top bar is a research bar. An article can be found by typing a tag in. A tag is manually set by the user, and is stored in an XML file so that all tags are recovered for the next launch of the software.
By right click, it is possible to delete a paper from the current bibliography.
Depending on the articles read, a list of suggestions is proposed at the bottom of the window.


## Requirements

- JAVA >= 8.0

## Documentation

A javadoc folder is located inside the main folder, and provides all classes' documentation in an html file.

## Restrictions

This software uses some free Microsoft Academic Knowledge libraries, and only allows 1000 requests per month, and 5 per second.


