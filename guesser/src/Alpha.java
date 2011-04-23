package net.cruciblesoftware.jotto;

enum Alpha {
    A, B, C, D, E, F, G, H, I, J, K, L, M,
    N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    public AlphaState state = AlphaState.UNKNOWN;

    public boolean isIn(String str) {
        return false;

    }

}
