package com.example;

import java.util.Random;

public final class JokeSource {
    private final Random mRandom = new Random();

    private final String[] mJokeList = {
            "Nothing ruins a Friday more than an understanding that today is Tuesday.",
            "If i had a dollar for every girl that found me unattractive, they would eventually find me attractive.",
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\".",
            "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car.",
            "Life is all about perspective. The sinking of the Titanic was a miracle to the lobsters in the ship's kitchen.",
            "Apparently I snore so loudly that it scares everyone in the car I'm driving.",
            "That awkward moment when you leave a store without buying anything and all you can think is \"act natural, you're innocent\".",
            "Isn't it great to live in the 21st century? Where deleting history has become more important than making it.",
            "When wearing a bikini, women reveal 90 % of their body... men are so polite they only look at the covered parts.",
            "I'm great at multitasking. I can waste time, be unproductive, and procrastinate all at once.",
            "You know you're ugly when it comes to a group picture and they hand you the camera.",
            "The grass may be greener on the other side but at least you don't have to mow it.",
            "I hate when I am about to hug someone really sexy and my face hits the mirror.",
            "I think my neighbor is stalking me as she's been googling my name on her computer. I saw it through my telescope last night.",
            "Is your ass jealous of the amount of shit that just came out of your mouth?",
            "I named my hard drive \"dat ass\" so once a month my computer asks if I want to 'back dat ass up'.",
            "Strong people don't put others down. They lift them up and slam them on the ground for maximum damage.",
            "Money talks ...but all mine ever says is good-bye.",
            "If you think nobody cares whether you're alive, try missing a couple of payments.",
            "You're not fat, you're just... easier to see.",
            "People are making end of the world jokes. Like there is no tomorrow.",
            "My therapist says I have a preoccupation with vengeance. We'll see about that.",
            "Life is like toilet paper, you're either on a roll or taking shit from some asshole.",
            "Politicians and diapers have one thing in common. They should both be changed regularly, and for the same reason.",
            "When an employment application asks who is to be notified in case of emergency, I always write, \"A very good doctor\".",
            "When I call a family meeting I turn off the house wifi and wait for them all to come running.",
            "Hospitality: making your guests feel like they're at home, even if you wish they were.",
            "There are few things I enjoy more than picking an argument with my girlfriend when she has the hiccups.",
            "I sometimes watch birds and wonder \"If I could fly who would I shit on?\"",
            "Wife: \"I look fat. Can you give me a compliment?\" Husband: \"You have perfect eyesight.\"",
            "Some people say \"If you can't beat them, join them\". I say \"If you can't beat them, beat them\", because they will be expecting you to join them, so you will have the element of surprise.",
            "Two wrongs don't make a right, take your parents as an example.",
            "I'm not saying I hate you, but I would unplug your life support to charge my phone.",
            "Relationships are a lot like algebra. Have you ever looked at your X and wondered Y?",
            "A clean house is the sign of a broken computer.",
            "I started out with nothing, and I still have most of it.",
            "Love is telling someone to go to hell and worrying about them getting there safely.",
            "There are three kinds of people: Those who can count and those who can't.",
            "Team work is important; it helps to put the blame on someone else.",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "You're so ugly, you scared the crap out of the toilet.",
            "I eat my tacos over a Tortilla. That way when stuff falls out, BOOM, another taco.",
            "Never laugh at your girlfriends choices... your one of them.",
            "My ex wrote to me: Can you delete my number? I responded: Who is this?",
            "If you're not supposed to eat at night, why is there a light bulb in the refrigerator?",
            "Top 3 situations that require witnesses: 1) Crimes 2) Accidents 3) Marriages Need I say more?"
    };

    public JokeSource() {}

    public String getAJoke() {
        return mJokeList[mRandom.nextInt(mJokeList.length)];
    }

}


