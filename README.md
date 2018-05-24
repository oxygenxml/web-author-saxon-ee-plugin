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


Using the operation
----------------

To use this operation in your framework you should.

- Extract the plugin in the `plugins` directory of your Oxygen XML Author/Editor.
- In your framework, choose "Use parent classloader from plugin with ID" and use `web-author-saxon-ee-plugin`.
- Choose the operation `com.oxygenxml.webapp.operations.xslt.SaxonEEXSLTOperation` and configure its parameters exactly like the ones for `XSLTOperation`.
- Export the framework.
- Deploy both the framework and this plugin in Web Author.
