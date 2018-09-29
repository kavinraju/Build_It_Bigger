package skr.jokes;

    public class JokesProvider {
        private String[] jokes = {
                "A blonde walked into an electronics store and said to the salesmen: \"I want that tv.\" \n" +
                        "The salesperson shook his head and said, \"No, we don't sell to blondes.\" \n" +
                        "So the blonde left and came back with her hair dyed brown and said: \"I'll take that tv.\" \n" +
                        "Again the salesman said: \"No, we don't sell to blondes.\" \n" +
                        "So she left again and came back with her hair dyed black and said: \"I want that tv.\" \n" +
                        "But the salesman still said: \"No, we don't sell to blondes.\" \n" +
                        "Finally the blonde got fed up and said, \"That's it! How'd you know I was a blonde?!\" she asked. \n" +
                        "The salesman answered: \"Cause that's a microwave.\"",

                "If you spell Chuck Norris wrong on Google it doesn't say, \"Did you mean Chuck Norris?\" \n" +
                        "It simply replies, \"Run while you still have the chance.\"",

                "There was once a young man who, in his youth, professed his desire to become a great writer.\n" +
                        "When asked to define \"Great\" he said,\n" +
                        "\"I want to write stuff that the whole world will read, stuff that people will react to on a truly emotional level, stuff that will make them scream, cry, howl in pain and anger!\"\n" +
                        "He now works for Microsoft, writing error messages.",

                "Two antennas met on a roof, fell in love and got married. \n" +
                        "The ceremony wasn’t much, but the reception was excellent.",

                "\n" +
                        "Google won't search for Chuck Norris because it knows you don't find Chuck Norris, he finds you.",

                "Funny facts about Google users:\n" +
                        "50% of people use Google well as a search engine.\n" +
                        "The rest 50% of them use it to check if their internet is connected",

                "The math teacher saw that little Johnny wasn't paying attention in class.\n" +
                        "She called on him and said, \"Johnny! \n" +
                        "What are 2 and 4 and 28 and 44?\"\n" +
                        "Little Johnny quickly replied, \"NBC, FOX, ESPN and the Cartoon Network!\"",

                "\"Siri, why am I still single?\"\n" +
                        "Siri activates front camera.",

                "My iPhone fell from the 20th floor. \n" +
                        "Good thing it was in airplane mode.",

                "Q: Why do Java programmers have to wear glasses?\n" +
                        "A: Because they don't C#.",
                "There's a band called 1023MB. They haven't had any gigs yet."
        };
        public String getJoke(int position) {
            if (position>0 && position<11) {
                return jokes[position];
            }else {
                return jokes[0];
            }
        }
    }