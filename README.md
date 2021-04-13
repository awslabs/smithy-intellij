## Smithy IntelliJ

**WARNING: This repository in development. All interfaces are subject to change.**

<!-- Plugin description -->
**Smithy IntelliJ** provides IDE integration for the [Smithy IDL](https://awslabs.github.io/smithy/) within
IntelliJ IDEA.  It utilizes [smithy-language-server](https://github.com/awslabs/smithy-language-server) for its
[Language Server Protocol](https://microsoft.github.io/language-server-protocol/) implementation.
<!-- Plugin description end -->

## Running this plugin for development
Clone the [smithy-language-server](https://github.com/awslabs/smithy-language-server) repository to a separate directory:
`git clone git@github.com:awslabs/smithy-language-server.git ~/smithy-language-server`

Change to that directory, and build and publish the locally:
`cd ~/smithy-language-server && ./gradlew build publishToMavenLocal`

From this plugin directory, use `ideRun` task to start a sandboxed instance of IntelliJ with the plugin loaded:
`./gradlew runIde`

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

