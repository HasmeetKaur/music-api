package com.example.musicapi.components;

import com.example.musicapi.models.Album;
import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import com.example.musicapi.models.Track;
import com.example.musicapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Artist milesDavis = new Artist("Miles Davis", Genre.JAZZ);
        Track track1 = new Track("Bags' Groove", milesDavis, Genre.JAZZ, 3.00);
        Track track2 = new Track("Bags' Groove - Take 2", milesDavis, Genre.JAZZ, 3.00);
        Track track3 = new Track("Airegin", milesDavis, Genre.JAZZ, 3.00);
        Track track4 = new Track("Oleo", milesDavis, Genre.JAZZ, 3.00);
        Track track5 = new Track("But Not For Me", milesDavis, Genre.JAZZ, 3.00);
        Track track6 = new Track("Doxy", milesDavis, Genre.JAZZ, 3.00);
        Track track7 = new Track("But Not For Me", milesDavis, Genre.JAZZ, 3.00);

        Album bagsGroove = new Album("Bags' Groove", milesDavis, 1957 ,Genre.JAZZ);
        bagsGroove.getTracks().add(track1);
        bagsGroove.getTracks().add(track2);
        bagsGroove.getTracks().add(track3);
        bagsGroove.getTracks().add(track4);
        bagsGroove.getTracks().add(track5);
        bagsGroove.getTracks().add(track6);
        bagsGroove.getTracks().add(track7);

        Artist pinkFloyd = new Artist("Pink Floyd", Genre.ROCK);
        Track track8 = new Track("Speak To Me / Breathe", pinkFloyd, Genre.ROCK, 4.00);
        Track track9 = new Track("On The Run", pinkFloyd, Genre.ROCK, 4.00);
        Track track10 = new Track("Time", pinkFloyd, Genre.ROCK, 4.00);
        Track track11 = new Track("The Great Gig In The Sky", pinkFloyd, Genre.ROCK, 4.00);
        Track track12 = new Track("Money", pinkFloyd, Genre.ROCK, 4.00);
        Track track13 = new Track("Us And Them", pinkFloyd, Genre.ROCK, 4.00);
        Track track14 = new Track("Any Colour You Like", pinkFloyd, Genre.ROCK, 4.00);
        Track track15 = new Track("Brain Damage", pinkFloyd, Genre.ROCK, 4.00);
        Track track16 = new Track("Eclipse", pinkFloyd, Genre.ROCK, 4.00);

        Album theDarkSideOfTheMoon = new Album("The Dark Side Of The Moon", pinkFloyd, 1973, Genre.ROCK);
        theDarkSideOfTheMoon.getTracks().add(track8);
        theDarkSideOfTheMoon.getTracks().add(track9);
        theDarkSideOfTheMoon.getTracks().add(track10);
        theDarkSideOfTheMoon.getTracks().add(track11);
        theDarkSideOfTheMoon.getTracks().add(track12);
        theDarkSideOfTheMoon.getTracks().add(track13);
        theDarkSideOfTheMoon.getTracks().add(track14);
        theDarkSideOfTheMoon.getTracks().add(track15);
        theDarkSideOfTheMoon.getTracks().add(track16);

        Artist bbKing = new Artist("B. B. King", Genre.BLUES);
        Track track17 = new Track("Introduction", bbKing, Genre.BLUES, 4.00);
        Track track18 = new Track("Everyday I Have The Blues", bbKing, Genre.BLUES, 4.00);
        Track track19 = new Track("How Blue Can You Get", bbKing, Genre.BLUES, 4.00);
        Track track20 = new Track("Worry, worry", bbKing, Genre.BLUES, 4.00);
        Track track21 = new Track("3 O'Clock Blues / Darlin' You Know I Love You", bbKing, Genre.BLUES, 4.00);
        Track track22 = new Track("Sweet Sixteen", bbKing, Genre.BLUES, 4.00);
        Track track23 = new Track("The Thrill Has Gone", bbKing, Genre.BLUES, 4.00);
        Track track24 = new Track("Please Accept My Love", bbKing, Genre.BLUES, 4.00);

        Album liveInCookCountyJail = new Album("Live In Cook County Jail", bbKing, 1971, Genre.BLUES);
        liveInCookCountyJail.getTracks().add(track17);
        liveInCookCountyJail.getTracks().add(track18);
        liveInCookCountyJail.getTracks().add(track19);
        liveInCookCountyJail.getTracks().add(track20);
        liveInCookCountyJail.getTracks().add(track21);
        liveInCookCountyJail.getTracks().add(track22);
        liveInCookCountyJail.getTracks().add(track23);
        liveInCookCountyJail.getTracks().add(track24);


        Artist dollyParton = new Artist("Dolly Parton", Genre.COUNTRY);
        Track track25 = new Track("Star of the Show", dollyParton, Genre.COUNTRY, 3.56);
        Track track26 = new Track("Down", dollyParton, Genre.COUNTRY,3.35);
        Track track27 = new Track("You're The Only One", dollyParton, Genre.COUNTRY, 3.21);
        Track track28 = new Track("Help", dollyParton, Genre.COUNTRY,2.45);
        Track track29 = new Track("Do You Think That Time Stands Still?", dollyParton, Genre.COUNTRY,3.56);
        Track track30 = new Track("Sweet Summer Lovin'", dollyParton, Genre.COUNTRY,3.17);
        Track track31 = new Track("Great Balls of Fire", dollyParton, Genre.COUNTRY,3.51);
        Track track32 = new Track("Almost in Love", dollyParton, Genre.COUNTRY,3.16);
        Track track33 = new Track("It's Not My Affair Anymore", dollyParton, Genre.COUNTRY,3.17);
        Track track34 = new Track("Sandy's Song", dollyParton, Genre.COUNTRY,3.19);

        Album greatBallsOfFire = new Album("Great Balls of Fire", dollyParton, 1979, Genre.COUNTRY);
        liveInCookCountyJail.getTracks().add(track17);
        liveInCookCountyJail.getTracks().add(track18);
        liveInCookCountyJail.getTracks().add(track19);
        liveInCookCountyJail.getTracks().add(track20);
        liveInCookCountyJail.getTracks().add(track21);
        liveInCookCountyJail.getTracks().add(track22);
        liveInCookCountyJail.getTracks().add(track23);
        liveInCookCountyJail.getTracks().add(track24);
    }
}
