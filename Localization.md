# How to implement localization? #

The best way to implement localization is a special class because we must not only localize messages, but also numbers and date formats.

For messages which is shown using POSLogger class is better to add special methods like infol or linfo which is show localized messages.