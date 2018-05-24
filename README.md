Web Author Saxon EE Plugin (for XSLTOperation)
==============================================

This plugins allows one to use SaxonEE to execute XSLT operations on the edited documents. 


Building the plugin
-------------------

Add your Saxon EE jar and your license to the `lib` folder and run 

```
mvn package
```

The plugin will be generated in the `target` folder and its name will be of the form `web-author-saxon-ee-plugin-*-plugin.jar`.


Using the plugin
----------------

After installing the plugin, you can use the following AuthorOperation `com.oxygenxml.webapp.operations.xslt.SaxonEEXSLTOperation`.