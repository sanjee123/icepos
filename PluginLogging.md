# Details #

To add logging you must use getLogger method of POSCore instance. This is specially done not using static methods, because we can't know where logging output must gone before GUI was started.

So standard logging work looks like:

  1. Logging system output directs to Console;
  1. POSCore reads settings from file, and sets logging level depends on seetings;
  1. After UI is started Core gets all loggers and attachs UI appender to all loggers. So user can be notified about all events in a right way.

### Logging levels ###

  * error - shows error message with red exclamation sign
  * warn - shows warning message with yellow exclamation sign
  * info - writes information message to message window