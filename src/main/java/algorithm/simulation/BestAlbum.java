package algorithm.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programmers
 * Level3 - Hash
 * 베스트 앨범
 */
public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> bestAlbumIds = new ArrayList<>();

        Map<Integer, Album> albumMap = initAlbumMap(genres, plays);
        Map<String, Integer> genresMap = initGenresMap(albumMap);
        String bestGenre = findBestGenre(genresMap);

        List<Album> bestGenreAlbums = initBestGenreAlbums(genres, albumMap, bestGenre);
        addBestGenreAlbum(bestAlbumIds, bestGenreAlbums);

        Map<String, Integer> otherGenreMap = initOtherGenreMap(bestGenre, genresMap);
        List<Album> otherGenreAlbums = initOtherGenreAlbums(otherGenreMap);

        addOtherGenreAlbumsId(bestAlbumIds, albumMap, otherGenreAlbums);

        return getAnswers(bestAlbumIds);
    }

    // 앨범 번호, 장르, 재생 횟수를 Map으로 초기화
    private Map<Integer, Album> initAlbumMap(String[] genres, int[] plays) {
        Map<Integer, Album> albumMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            albumMap.put(i, new Album(i, genres[i], plays[i]));
        }
        return albumMap;
    }

    // 어떠한 장르의 총 재생횟수는 몇인지 Map으로 초기화
    private Map<String, Integer> initGenresMap(Map<Integer, Album> albumMap) {
        Map<String, Integer> genresMap = new HashMap<>();
        for (int key : albumMap.keySet()) {
            Album album = albumMap.get(key);
            if (!genresMap.containsKey(album.genre)) {
                genresMap.put(album.genre, album.play);
                continue;
            }
            int currentAlbumPlay = genresMap.get(album.genre);
            genresMap.put(album.genre, currentAlbumPlay + album.play);
        }
        return genresMap;
    }

    // 베스트 장르 찾기
    private String findBestGenre(Map<String, Integer> genresMap) {
        String bestGenre = "";
        int playCount = Integer.MIN_VALUE;
        for (String genre : genresMap.keySet()) {
            Integer play = genresMap.get(genre);
            if (play > playCount) {
                playCount = play;
                bestGenre = genre;
            }
        }
        return bestGenre;
    }

    // 베스트 장르의 재생횟수 정렬
    private List<Album> initBestGenreAlbums(String[] genres, Map<Integer, Album> albumMap, String bestGenre) {
        List<Album> bestGenreAlbums = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            Album album = albumMap.get(i);
            if (bestGenre.equals(album.genre)) {
                bestGenreAlbums.add(album);
            }
        }
        bestGenreAlbums.sort((o1, o2) -> Integer.compare(o2.play, o1.play));
        return bestGenreAlbums;
    }

    // 베스트 장르의 앨범 1 ~ 2곡 저장
    private void addBestGenreAlbum(List<Integer> bestAlbumIds, List<Album> bestGenreAlbums) {
        for (int i = 0; i < 2; i++) {
            if (bestGenreAlbums.size() == 1) {
                bestAlbumIds.add(bestGenreAlbums.get(i).albumId);
                break;
            }
            bestAlbumIds.add(bestGenreAlbums.get(i).albumId);
        }
    }

    // 베스트 장르를 제외한 다른 장르를 맵으로 관리
    private Map<String, Integer> initOtherGenreMap(String bestGenre, Map<String, Integer> genresMap) {
        Map<String, Integer> otherGenreMap = new HashMap<>();
        for (String genre : genresMap.keySet()) {
            if (genre.equals(bestGenre)) {
                continue;
            }
            Integer play = genresMap.get(genre);
            otherGenreMap.put(genre, play);
        }
        return otherGenreMap;
    }

    // 다른 장르의 앨범을 총 재생 횟수가 높은 순으로 정렬
    private List<Album> initOtherGenreAlbums(Map<String, Integer> otherGenreMap) {
        List<Album> otherGenreAlbums = new ArrayList<>();

        for (String genre : otherGenreMap.keySet()) {
            Integer play = otherGenreMap.get(genre);
            otherGenreAlbums.add(new Album(genre, play));
        }
        otherGenreAlbums.sort((o1, o2) -> Integer.compare(o2.play, o1.play));
        return otherGenreAlbums;
    }

    // 다른 장르들에서 재생 순위가 높은 두 곡을 저장한다
    private void addOtherGenreAlbumsId(List<Integer> bestAlbumIds, Map<Integer, Album> albumMap, List<Album> otherGenreAlbums) {
        for (int i = 0; i < otherGenreAlbums.size(); i++) {
            Album otherGenreAlbum = otherGenreAlbums.get(i);
            String currentGenre = otherGenreAlbum.genre;

            List<Album> currentGenreAlbums = new ArrayList<>();
            for (int j = 0; j < albumMap.size(); j++) {
                Album album = albumMap.get(j);
                if (album.genre.equals(currentGenre)) {
                    currentGenreAlbums.add(new Album(j, album.genre, album.play));
                }
            }
            currentGenreAlbums.sort((o1, o2) -> Integer.compare(o2.play, o1.play));

            addOtherGenreAlbum(bestAlbumIds, currentGenreAlbums);
        }
    }

    // 다른 장르들의 앨범 중 가장 재생 횟수가 높은 두곡 저장
    private void addOtherGenreAlbum(List<Integer> bestAlbumIds, List<Album> currentGenreAlbums) {
        for (int i = 0; i < 2; i++) {
            if (currentGenreAlbums.size() == 1) {
                bestAlbumIds.add(currentGenreAlbums.get(i).albumId);
                break;
            }
            bestAlbumIds.add(currentGenreAlbums.get(i).albumId);
        }
    }

    private int[] getAnswers(List<Integer> bestAlbumIds) {
        int[] answers = new int[bestAlbumIds.size()];

        for (int i = 0; i < bestAlbumIds.size(); i++) {
            answers[i] = bestAlbumIds.get(i);
        }
        return answers;
    }

    static class Album {
        int albumId;
        String genre;
        int play;

        public Album(int albumId, String genre, int play) {
            this.albumId = albumId;
            this.genre = genre;
            this.play = play;
        }

        public Album(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
    }
}
